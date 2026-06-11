package com.example.lld.test.parkingLot2.models;

import java.util.List;

public class ParkingFloor {
    private String id;
    private List<Spot> parkingSpots;

    public ParkingFloor(List<Spot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public List<Spot> getParkingSpots() {
        return this.parkingSpots;
    }
}
