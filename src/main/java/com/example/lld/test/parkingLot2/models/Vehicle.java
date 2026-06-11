package com.example.lld.test.parkingLot2.models;

import com.example.lld.test.parkingLot2.enums.VehicleType;

public class Vehicle {
    private String licenseNumber;
    private VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public VehicleType getType() {
        return this.type;
    }
}
