package com.example.lld.test.ParkingLot3.models;

import com.example.lld.test.ParkingLot3.enums.ParkingSlotType;

import java.util.UUID;

public class ParkingSpot {
    private Vehicle vehicle;
    private final String id;
    private final ParkingSlotType parkingSlotType;

    public ParkingSpot(ParkingSlotType parkingSlotType) {
        this.id = UUID.randomUUID().toString();
        this.parkingSlotType = parkingSlotType;
    }

    public ParkingSlotType getParkingSlotType() {
        return this.parkingSlotType;
    }

    public String getParkingSlotId() {
        return this.id;
    }

    public boolean isParkingSlotFree() {
        return this.vehicle == null;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
