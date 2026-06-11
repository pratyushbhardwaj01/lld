package com.example.lld.test.parkingLot2.models;

import com.example.lld.test.parkingLot2.enums.TicketStatus;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private Instant entryTime;
    private Instant exitTime;
    private Spot spot;
    private String vehicleId;
    private TicketStatus status;
    private String id;

    public Ticket() {
        this.entryTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
        this.id = UUID.randomUUID().toString();
    }

    public void setTicketStatus(TicketStatus status) {
        this.status = status;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setSpotId(Spot spot) {
        this.spot = spot;
    }

    public TicketStatus getStatus() {
        return this.status;
    }

    public String getTicketId() {
        return this.id;
    }

    public Instant getEntryTime() {
        return this.entryTime;
    }

    public Instant getExitTime() {
        return this.exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public Spot getSpot() {
        return this.spot;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

}
