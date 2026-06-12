package com.example.lld.test.ParkingLot3;

import com.example.lld.test.ParkingLot3.definations.FareCalculationStrategy;
import com.example.lld.test.ParkingLot3.definations.SpaceAllocationStrategy;
import com.example.lld.test.ParkingLot3.definations.impl.BestSpaceAllocationStrategy;
import com.example.lld.test.ParkingLot3.definations.impl.WeekdayFareCalculationStrategy;
import com.example.lld.test.ParkingLot3.enums.ParkingSlotType;
import com.example.lld.test.ParkingLot3.enums.VehicleType;
import com.example.lld.test.ParkingLot3.models.ParkingFloor;
import com.example.lld.test.ParkingLot3.models.ParkingSpot;
import com.example.lld.test.ParkingLot3.models.Ticket;
import com.example.lld.test.ParkingLot3.models.Vehicle;
import com.example.lld.test.ParkingLot3.services.ParkingService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FareCalculationStrategy fareCalculationStrategy = new WeekdayFareCalculationStrategy();
        SpaceAllocationStrategy spaceAllocationStrategy = new BestSpaceAllocationStrategy();
        ParkingService parkingService = ParkingService.getParkingServiceInstance();
        parkingService.setParkingFloorList(createFloors(4));
        parkingService.setFareCalculationStrategy(fareCalculationStrategy);
        parkingService.setSpaceAllocationStrategy(spaceAllocationStrategy);
        Vehicle vehicle = new Vehicle("BH 1234", VehicleType.SMALL);
        Ticket ticket = parkingService.parkVehicle(vehicle);
        try{
            Thread.sleep(2000);
            parkingService.unparkVehicle(ticket);
        }
        catch (Exception e) {
            System.out.println("Thread exception");
        }

    }

    public static List<ParkingFloor> createFloors(int floors) {

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for (int i = 0; i < floors; i++) {
            List<ParkingSpot> parkingSpotList = new ArrayList<>();
            parkingSpotList.add(createParkingSpot(1));
            parkingSpotList.add(createParkingSpot(2));
            parkingSpotList.add(createParkingSpot(3));
            parkingSpotList.add(createParkingSpot(4));
            Collections.shuffle(parkingSpotList);
            ParkingFloor parkingFloor = new ParkingFloor(parkingSpotList, i + 1);
            parkingFloorList.add(parkingFloor);
        }
        return parkingFloorList;
    }

    public static ParkingSpot createParkingSpot(int spotType) {
        return switch (spotType) {
            case 1 -> new ParkingSpot(ParkingSlotType.COMPACT);
            case 2 -> new ParkingSpot(ParkingSlotType.SMALL);
            case 3 -> new ParkingSpot(ParkingSlotType.MEDIUM);
            case 4 -> new ParkingSpot(ParkingSlotType.LARGE);
            default -> null;
        };
    }
}
