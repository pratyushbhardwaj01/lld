package com.example.lld.test.ParkingLot3.enums;

public enum VehicleType {
    SMALL(1), MEDIUM(2), LARGE(3);
    private final int size;

    VehicleType(int size) {
        this.size = size;
    }

    public int getVehicleSize() {
        return this.size;
    }
}
