package com.example.lld.test.ParkingLot3.models;

import java.util.List;

public class ParkingFloor {
    private final List<ParkingSpot> parkingSpotList;
    private final int floorNumber;


    public ParkingFloor(List<ParkingSpot> parkingSpotList, int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpotList = parkingSpotList;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return this.parkingSpotList;
    }
}
