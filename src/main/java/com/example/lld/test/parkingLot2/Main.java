package com.example.lld.test.parkingLot2;

import com.example.lld.test.parkingLot2.enums.ParkingSpotType;
import com.example.lld.test.parkingLot2.enums.VehicleType;
import com.example.lld.test.parkingLot2.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingFloor floor1 = new ParkingFloor(createParkingFloor(List.of(ParkingSpotType.SMALL, ParkingSpotType.MEDIUM, ParkingSpotType.COMPACT)));
        ParkingFloor floor2 = new ParkingFloor(createParkingFloor(List.of(ParkingSpotType.SMALL, ParkingSpotType.MEDIUM, ParkingSpotType.COMPACT)));
        ParkingFloor floor3 = new ParkingFloor(createParkingFloor(List.of(ParkingSpotType.SMALL, ParkingSpotType.MEDIUM, ParkingSpotType.COMPACT)));
        ParkingSystem parkingSystem = ParkingSystem.getParkingSystemInstance(List.of(floor1, floor2, floor3));
        Vehicle scooter = new Vehicle("Barb02j", VehicleType.SMALL);
        Ticket t1 = parkingSystem.parkVehicle(scooter);
        parkingSystem.unParkVehicle(t1);
    }


    public static List<Spot> createParkingFloor(List<ParkingSpotType> parkingSpotTypes) {
        List<Spot> floor = new ArrayList<>();
        for (ParkingSpotType parkingSpotType : parkingSpotTypes) {
            floor.add(new Spot(parkingSpotType));
        }
        return floor;
    }
}
