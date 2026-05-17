package com.example.lld.template.parkinglotsystem.models;

import com.example.lld.template.parkinglotsystem.definations.Gate;
import com.example.lld.template.parkinglotsystem.enums.TicketStatus;

import java.time.Instant;

public class Ticket {
    private final String id;
    private final Instant entryTime;
    private Instant exitTime;
    private final Gate entryGate;
    private Gate exitGate;
    private final ParkingSlot parkingSlot;
    private TicketStatus ticketStatus;

    public static class Builder {
        private String id;
        private Instant entryTime;
        private Gate entryGate;
        private ParkingSlot parkingSlot;
        private TicketStatus ticketStatus;

        public Builder setTicketId(String id) {
            this.id = id;
            return this;
        }

        public Builder setVehicleEntryTime(Instant entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder setEntryGate(Gate entryGate) {
            this.entryGate = entryGate;
            return this;
        }

        public Builder setParkingSpot(ParkingSlot parkingSlot) {
            this.parkingSlot = parkingSlot;
            return this;
        }

        public Builder setTicketStatus(TicketStatus ticketStatus) {
            this.ticketStatus = ticketStatus;
            return this;
        }

        public Ticket build() {
            if (id == null || entryTime == null || entryGate == null || parkingSlot == null) {
                throw new IllegalArgumentException("Missing required fields");
            }
            return new Ticket(this);
        }
    }

    private Ticket(Builder builder) {
        this.id = builder.id;
        this.entryTime = builder.entryTime;
        this.entryGate = builder.entryGate;
        this.parkingSlot = builder.parkingSlot;
        this.ticketStatus = builder.ticketStatus;

    }

    public ParkingSlot getParkingSlot() {
        return this.parkingSlot;
    }

    public Instant getEntryTime() {
        return this.entryTime;
    }

    public Instant getExitTime() {
        return this.exitTime;
    }

    public synchronized void markExited(Gate exitGate, Instant exitTime) {
        if (this.ticketStatus != TicketStatus.ACTIVE) throw new IllegalStateException("Ticked already closed");
        this.exitGate = exitGate;
        this.exitTime = exitTime;
        this.ticketStatus = TicketStatus.IN_ACTIVE;
    }
}
