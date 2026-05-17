package com.example.lld.template.parkinglotsystem.enums;

public enum VehicleTypes {
    TWO_WHEELER(2), THREE_WHEELER(3), FOUR_WHEELER(4);

    private final int vehicleSize;

    VehicleTypes(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public int getVehicleSize() {
        return this.vehicleSize;
    }
}
