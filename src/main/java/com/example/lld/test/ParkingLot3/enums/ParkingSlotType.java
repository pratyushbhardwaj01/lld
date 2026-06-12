package com.example.lld.test.ParkingLot3.enums;

public enum ParkingSlotType {
    COMPACT(1), SMALL(2), MEDIUM(3), LARGE(4);
    private final int size;

    ParkingSlotType(int size) {
        this.size = size;
    }

    public int getParkingSlotSize() {
        return this.size;
    }
}
