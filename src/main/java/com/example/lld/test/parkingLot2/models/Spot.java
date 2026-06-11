package com.example.lld.test.parkingLot2.models;

import com.example.lld.test.parkingLot2.enums.ParkingSpotType;

import java.util.UUID;

public class Spot {
    private String id;
    private ParkingSpotType type;
    private Vehicle vehicle;


    public Spot(ParkingSpotType parkingSpotType) {
        this.type = parkingSpotType;
        this.id = UUID.randomUUID().toString();
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unparkVehicle() {
        this.vehicle = null;
    }

    public ParkingSpotType getType() {
        return this.type;
    }

    public Boolean isAvailable() {
        return this.vehicle == null;
    }

    public String getId() {
        return this.id;
    }
}
