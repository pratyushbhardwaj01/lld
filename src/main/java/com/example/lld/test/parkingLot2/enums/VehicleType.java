package com.example.lld.test.parkingLot2.enums;

public enum VehicleType {
    SMALL(1), MEDIUM(2), LARGE(3);

    private int size;

    VehicleType(int size) {
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }

}
