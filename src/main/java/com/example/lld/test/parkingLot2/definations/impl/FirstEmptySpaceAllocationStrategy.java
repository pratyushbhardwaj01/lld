package com.example.lld.test.parkingLot2.definations.impl;

import com.example.lld.test.parkingLot2.definations.EmptySpaceAllocationStrategy;
import com.example.lld.test.parkingLot2.models.ParkingFloor;
import com.example.lld.test.parkingLot2.models.Spot;
import com.example.lld.test.parkingLot2.models.Vehicle;

import java.util.List;

public class FirstEmptySpaceAllocationStrategy implements EmptySpaceAllocationStrategy {
    @Override
    public Spot addVehicle(Vehicle vehicle, List<ParkingFloor> parkingFloorList) {

        for (ParkingFloor parkingFloor : parkingFloorList) {
            for (Spot spot : parkingFloor.getParkingSpots()) {
                int vehicleSize = vehicle.getType().getSize();
                int parkingSpotSize = spot.getType().getSize();
                if (vehicleSize <= parkingSpotSize && spot.isAvailable()) {
                    spot.parkVehicle(vehicle);
                    return spot;
                }
            }
        }
        return null;
    }
}
