package com.example.lld.template.parkinglotsystem;


import com.example.lld.template.parkinglotsystem.definations.EntryGate;
import com.example.lld.template.parkinglotsystem.definations.ExitGate;
import com.example.lld.template.parkinglotsystem.definations.FareCalculationStrategy;
import com.example.lld.template.parkinglotsystem.definations.impl.EntryGateImpl;
import com.example.lld.template.parkinglotsystem.definations.impl.ExitGateImpl;
import com.example.lld.template.parkinglotsystem.definations.impl.SecondBasedFareCalculationStrategy;
import com.example.lld.template.parkinglotsystem.enums.ParkingSlotTypes;
import com.example.lld.template.parkinglotsystem.enums.VehicleTypes;
import com.example.lld.template.parkinglotsystem.models.*;
import com.example.lld.template.parkinglotsystem.services.ParkingSystemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSlot ps1 = new ParkingSlot("101", ParkingSlotTypes.COMPACT);
        ParkingSlot ps2 = new ParkingSlot("102", ParkingSlotTypes.SMALL);
        ParkingSlot ps3 = new ParkingSlot("103", ParkingSlotTypes.MEDIUM);
        ParkingSlot ps21 = new ParkingSlot("201", ParkingSlotTypes.COMPACT);
        ParkingSlot ps22 = new ParkingSlot("202", ParkingSlotTypes.SMALL);
        ParkingSlot ps23 = new ParkingSlot("203", ParkingSlotTypes.MEDIUM);

        Vehicle v1 = new Vehicle("1234", VehicleTypes.TWO_WHEELER);
        List<ParkingSlot> slots1 = new ArrayList(Arrays.asList(ps21, ps22, ps23));
        List<ParkingSlot> slots2 = new ArrayList(Arrays.asList(ps1, ps2, ps3));

        ParkingFloor pf1 = new ParkingFloor(slots1, 1);
        ParkingFloor pf2 = new ParkingFloor(slots2, 2);

        List<ParkingFloor> parkingFloors = new ArrayList();
        parkingFloors.add(pf1);
        parkingFloors.add(pf2);
        FareCalculationStrategy fareCalculationStrategy = new SecondBasedFareCalculationStrategy();
        ParkingSystemService parkingSystemService = new ParkingSystemService(parkingFloors, fareCalculationStrategy);
        EntryGate entryGate = new EntryGateImpl(1, parkingSystemService);
        ExitGate exitGate = new ExitGateImpl(1, parkingSystemService);
        Ticket ticket = entryGate.processEntry(v1);
        try {
            Thread.sleep(5000);
            exitGate.processExit(ticket);
        } catch (Exception ex) {
            System.out.println("failed to sleep");
            System.out.println(ex);
        }
    }
}
