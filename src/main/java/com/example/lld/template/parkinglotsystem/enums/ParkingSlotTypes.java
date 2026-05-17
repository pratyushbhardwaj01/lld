package com.example.lld.template.parkinglotsystem.enums;

public enum ParkingSlotTypes {
    COMPACT(2), SMALL(3), MEDIUM(4);

    private final int parkingSlotSize;

    ParkingSlotTypes(int parkingSlotSize) {
        this.parkingSlotSize = parkingSlotSize;
    }

    public int getParkingSlotSize() {
        return this.parkingSlotSize;
    }
    }
