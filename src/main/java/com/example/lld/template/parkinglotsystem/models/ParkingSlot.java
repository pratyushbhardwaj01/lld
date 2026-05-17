package com.example.lld.template.parkinglotsystem.models;

import com.example.lld.template.parkinglotsystem.enums.ParkingSlotTypes;
import com.example.lld.template.parkinglotsystem.exceptions.SlotAlreadyEmptyException;
import com.example.lld.template.parkinglotsystem.exceptions.SlotAlreadyOccupiedException;

public class ParkingSlot {
    private String id;
    private ParkingSlotTypes parkingSlotType;
    private volatile Vehicle vehicle;
    private volatile boolean isAvailable;

    public ParkingSlot(String id, ParkingSlotTypes parkingSlotType) {
        this.id = id;
        this.parkingSlotType = parkingSlotType;
        this.isAvailable = true;
    }

    public synchronized boolean isSlotFitForVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().getVehicleSize() <= parkingSlotType.getParkingSlotSize() && this.isAvailable;

    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("vehicle is null");
        }
        if (!isAvailable) {
            throw new SlotAlreadyOccupiedException(this);
        }
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public synchronized void unParkVehicle() {
        if (this.vehicle == null) {
            throw new SlotAlreadyEmptyException(this);
        }
        this.vehicle = null;
        this.isAvailable = true;
    }

    public String getSlotId() {
        return this.id;
    }

    public synchronized Vehicle getVehicleInfo() {
        return this.vehicle;
    }

}
