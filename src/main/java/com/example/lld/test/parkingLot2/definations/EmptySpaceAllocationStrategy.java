package com.example.lld.test.parkingLot2.definations;

import com.example.lld.test.parkingLot2.models.ParkingFloor;
import com.example.lld.test.parkingLot2.models.Spot;
import com.example.lld.test.parkingLot2.models.Vehicle;

import java.util.List;

public interface EmptySpaceAllocationStrategy {
    public Spot addVehicle(Vehicle vehicle, List<ParkingFloor> parkingFloors);
}
