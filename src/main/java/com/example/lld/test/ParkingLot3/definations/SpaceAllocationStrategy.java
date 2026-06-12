package com.example.lld.test.ParkingLot3.definations;

import com.example.lld.test.ParkingLot3.models.ParkingFloor;
import com.example.lld.test.ParkingLot3.models.ParkingSpot;
import com.example.lld.test.ParkingLot3.models.Vehicle;

import java.util.List;

public interface SpaceAllocationStrategy {
    public ParkingSpot allocateSpace(List<ParkingFloor> parkingFloorList, Vehicle vehicle);
}
