package com.example.lld.template.parkinglotsystem.definations.impl;

import com.example.lld.template.parkinglotsystem.definations.EntryGate;
import com.example.lld.template.parkinglotsystem.models.Ticket;
import com.example.lld.template.parkinglotsystem.models.Vehicle;
import com.example.lld.template.parkinglotsystem.services.ParkingSystemService;

public class EntryGateImpl implements EntryGate {
    private int entryGateId;
    private ParkingSystemService parkingSystemService;

    public EntryGateImpl(int entryGateId, ParkingSystemService parkingSystemService) {
        this.entryGateId = entryGateId;
        this.parkingSystemService = parkingSystemService;
    }

    @Override
    public int getId() {
        return entryGateId;
    }

    @Override
    public Ticket processEntry(Vehicle vehicle) {
        return parkingSystemService.allocateSpace(vehicle, this);

    }
}
