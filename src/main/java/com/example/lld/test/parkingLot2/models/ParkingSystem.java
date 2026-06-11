package com.example.lld.test.parkingLot2.models;

import com.example.lld.test.parkingLot2.definations.EmptySpaceAllocationStrategy;
import com.example.lld.test.parkingLot2.definations.FareCalculationStrategy;
import com.example.lld.test.parkingLot2.definations.impl.FirstEmptySpaceAllocationStrategy;
import com.example.lld.test.parkingLot2.definations.impl.PeakTimeFareStrategy;
import com.example.lld.test.parkingLot2.enums.TicketStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class ParkingSystem {
    private static ParkingSystem parkingSystem;
    private EmptySpaceAllocationStrategy emptySpaceAllocationStrategy;
    private FareCalculationStrategy peakTimeFareCalculationStrategy;
    private List<ParkingFloor> floorList;

    private ParkingSystem(List<ParkingFloor> floorList) {
        this.floorList = floorList;
        this.emptySpaceAllocationStrategy = new FirstEmptySpaceAllocationStrategy();
        this.peakTimeFareCalculationStrategy = new PeakTimeFareStrategy();
    }

    public synchronized static ParkingSystem getParkingSystemInstance(List<ParkingFloor> floorList) {
        if (parkingSystem == null) {
            parkingSystem =  new ParkingSystem(floorList);
        }
        return parkingSystem;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        Spot spot = emptySpaceAllocationStrategy.addVehicle(vehicle, floorList);
        if (spot == null) {
            System.out.println("No available space in the parking system for the vehicle: " + vehicle.getLicenseNumber());
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setVehicleId(vehicle.getLicenseNumber());
        ticket.setSpotId(spot);
        System.out.println("The vehicle parked successfully at spotId: " + spot.getId() + " spotType " + spot.getType() + " vehicleId: " + vehicle.getLicenseNumber());
        return ticket;
    }

    public synchronized void unParkVehicle(Ticket ticket) {
        if (ticket.getStatus() == TicketStatus.EXPIRED) {
            System.out.println("The ticket is already expired...." + ticket.getTicketId());
            return;
        }
        ticket.setExitTime(Instant.now());
        ticket.setTicketStatus(TicketStatus.EXPIRED);
        BigDecimal totalFare = peakTimeFareCalculationStrategy.calculateFare(ticket);
        Spot spot = ticket.getSpot();
        spot.unparkVehicle();
        System.out.println("Unparked Successfully vehicleId: " + ticket.getVehicleId() + " with total fare " + totalFare.toString());
    }
}
