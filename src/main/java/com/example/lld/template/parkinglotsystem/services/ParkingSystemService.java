package com.example.lld.template.parkinglotsystem.services;

import com.example.lld.template.parkinglotsystem.definations.EntryGate;
import com.example.lld.template.parkinglotsystem.definations.ExitGate;
import com.example.lld.template.parkinglotsystem.definations.FareCalculationStrategy;
import com.example.lld.template.parkinglotsystem.enums.TicketStatus;
import com.example.lld.template.parkinglotsystem.exceptions.LotFullException;
import com.example.lld.template.parkinglotsystem.exceptions.SlotAlreadyOccupiedException;
import com.example.lld.template.parkinglotsystem.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class ParkingSystemService {
    private List<ParkingFloor> parkingFloors;
    private FareCalculationStrategy strategy;
    private static final Logger logger = LoggerFactory.getLogger(ParkingSystemService.class);

    public ParkingSystemService(List<ParkingFloor> parkingFloors, FareCalculationStrategy strategy) {
        this.parkingFloors = parkingFloors;
        this.strategy = strategy;
    }

    private ParkingSlot getParkingSlot(Vehicle vehicle) {
        ParkingSlot availableSlot = null;
        for (ParkingFloor floor : parkingFloors) {
            availableSlot = floor.getAvailableSlot(vehicle);
            if (availableSlot != null) {
                return availableSlot;
            }
        }
        return availableSlot;
    }

    public synchronized Ticket allocateSpace(Vehicle vehicle, EntryGate entryGate) {
        while (true) {
            ParkingSlot parkingSlot = getParkingSlot(vehicle);
            if (parkingSlot == null) {
                throw new LotFullException(vehicle.getVehicleType());
            }
            try {
                parkingSlot.parkVehicle(vehicle);
            } catch (SlotAlreadyOccupiedException raced) {
                continue;
            }
            logger.info("Parked vehicle vehicleNumber {} parked at parkingSpotId {}", vehicle.getVehicleNumber(), parkingSlot.getSlotId());
            return new Ticket.Builder().setTicketId(UUID.randomUUID().toString()).setVehicleEntryTime(Instant.now()).setEntryGate(entryGate).setParkingSpot(parkingSlot).setTicketStatus(TicketStatus.ACTIVE).build();
        }
    }

    public synchronized double deallocateSpace(Ticket ticket, ExitGate gate) {
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        Vehicle vehicleInfo = parkingSlot.getVehicleInfo();
        ticket.markExited(gate, Instant.now());
        parkingSlot.unParkVehicle();
        double totalfare = strategy.calculateFare(ticket);
        logger.info("Unparked vehicle vehicleNumber: {} parked at parkingSlotId: {} with total fare: {}", vehicleInfo.getVehicleNumber(), parkingSlot.getSlotId(), totalfare);
        return totalfare;
    }
}
