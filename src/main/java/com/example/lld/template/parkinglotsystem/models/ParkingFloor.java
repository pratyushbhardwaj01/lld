package com.example.lld.template.parkinglotsystem.models;

import java.util.List;

public class ParkingFloor {
    private List<ParkingSlot> slots;
    private int floorNumber;

    public ParkingFloor(List<ParkingSlot> slots, int floorNumber) {
        this.slots = slots;
        this.floorNumber = floorNumber;
    }

    public ParkingSlot getAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.isSlotFitForVehicle(vehicle)) {
                return slot;
            }
        }
        return null;
    }
}
