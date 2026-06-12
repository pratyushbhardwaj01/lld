package com.example.lld.test.ParkingLot3.models;

import com.example.lld.test.ParkingLot3.enums.VehicleType;

public class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
