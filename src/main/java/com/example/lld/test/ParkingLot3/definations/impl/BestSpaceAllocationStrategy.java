package com.example.lld.test.ParkingLot3.definations.impl;

import com.example.lld.test.ParkingLot3.definations.SpaceAllocationStrategy;
import com.example.lld.test.ParkingLot3.models.ParkingFloor;
import com.example.lld.test.ParkingLot3.models.ParkingSpot;
import com.example.lld.test.ParkingLot3.models.Vehicle;

import java.util.List;

public class BestSpaceAllocationStrategy implements SpaceAllocationStrategy {
    @Override
    public ParkingSpot allocateSpace(List<ParkingFloor> parkingFloorList, Vehicle vehicle) {
        ParkingSpot parkingSpotSpace = null;
        for (ParkingFloor parkingFloor : parkingFloorList) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpotList()) {
                if (parkingSpot.isParkingSlotFree() && parkingSpot.getParkingSlotType().getParkingSlotSize() >= vehicle.getVehicleType().getVehicleSize()) {
                    if (parkingSpotSpace == null) {
                        parkingSpotSpace = parkingSpot;
                    } else {
                        if (parkingSpot.getParkingSlotType().getParkingSlotSize() < parkingSpotSpace.getParkingSlotType().getParkingSlotSize()) {
                            parkingSpotSpace = parkingSpot;
                        }
                    }
                }
            }
        }
        if (parkingSpotSpace == null) {
            return null;
        }

        parkingSpotSpace.setVehicle(vehicle);
        return parkingSpotSpace;
    }
}
