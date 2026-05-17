package com.example.lld.template.parkinglotsystem.models;

import com.example.lld.template.parkinglotsystem.enums.VehicleTypes;

public class Vehicle {
    private String vehicleNumber;
    private VehicleTypes vehicleType;

    public Vehicle(String vehicleNumber, VehicleTypes vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleTypes getVehicleType() {
        return this.vehicleType;
    }
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
}
