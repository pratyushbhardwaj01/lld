package com.example.lld.test.ParkingLot3.models;

import com.example.lld.test.ParkingLot3.enums.TicketStatus;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private final String id;
    private ParkingSpot parkingSpot;
    private final Instant entryTime;
    private Instant exitTime;
    private TicketStatus status;
    private Vehicle vehicle;

    public Ticket() {
        this.id = UUID.randomUUID().toString();
        this.entryTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
    }

    public TicketStatus getTicketStatus() {
        return this.status;
    }

    public Instant getEntryTime() {
        return this.entryTime;
    }

    public Instant getExitTime() {
        return this.exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }

    public void updateTicketStatus(TicketStatus status) {
        this.status = status;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
