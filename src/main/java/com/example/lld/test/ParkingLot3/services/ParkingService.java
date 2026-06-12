package com.example.lld.test.ParkingLot3.services;

import com.example.lld.test.ParkingLot3.definations.FareCalculationStrategy;
import com.example.lld.test.ParkingLot3.definations.SpaceAllocationStrategy;
import com.example.lld.test.ParkingLot3.enums.TicketStatus;
import com.example.lld.test.ParkingLot3.models.ParkingFloor;
import com.example.lld.test.ParkingLot3.models.ParkingSpot;
import com.example.lld.test.ParkingLot3.models.Ticket;
import com.example.lld.test.ParkingLot3.models.Vehicle;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class ParkingService {
    private static ParkingService parkingService;
    private List<ParkingFloor> parkingFloorList;
    private FareCalculationStrategy fareCalculationStrategy;
    private SpaceAllocationStrategy spaceAllocationStrategy;

   private ParkingService() {}

    public static synchronized ParkingService getParkingServiceInstance() {
        if (parkingService == null) {
            parkingService = new ParkingService();
        }
        return parkingService;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.out.println("Please pass a vehicle to park...");
            return null;
        }
        ParkingSpot parkingSpot = spaceAllocationStrategy.allocateSpace(parkingFloorList, vehicle);
        if (parkingSpot == null) {
            System.out.println("The parking is full please wait....");
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        System.out.println("The vehicle parked successfully at parkingSpotId " + parkingSpot.getParkingSlotId() + " parkingSlotType " + parkingSpot.getParkingSlotType() + " with Vehicle Number " + vehicle.getLicensePlate());
        return ticket;
    }

    public synchronized void unparkVehicle(Ticket ticket) {
       if(ticket == null) {
           System.out.println("The ticket is null...");
           return;
       }
       if (ticket.getTicketStatus() == TicketStatus.EXPIRED) {
            System.out.println("The ticket is already expired");
            return;
        }
        ticket.setExitTime(Instant.now());
        BigDecimal fare = fareCalculationStrategy.calculatePrice(ticket);
        ticket.updateTicketStatus(TicketStatus.EXPIRED);
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        Vehicle vehicle = ticket.getVehicle();
        System.out.println("The vehicle un-parked successfully at parkingSpotId " + parkingSpot.getParkingSlotId() + " parkingSlotType " + parkingSpot.getParkingSlotType() + " with Vehicle Number " + vehicle.getLicensePlate() + " with fare " + fare);
        parkingSpot.setVehicle(null);
    }

    public synchronized void setFareCalculationStrategy(FareCalculationStrategy fareCalculationStrategy) {
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    public synchronized void setSpaceAllocationStrategy(SpaceAllocationStrategy spaceAllocationStrategy) {
        this.spaceAllocationStrategy = spaceAllocationStrategy;
    }

    public synchronized void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
}
