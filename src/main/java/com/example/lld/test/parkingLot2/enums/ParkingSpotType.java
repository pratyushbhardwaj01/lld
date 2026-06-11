package com.example.lld.test.parkingLot2.enums;

public enum ParkingSpotType {
    SMALL(1), MEDIUM(2), COMPACT(3);

    private int size;

    ParkingSpotType(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
    }
