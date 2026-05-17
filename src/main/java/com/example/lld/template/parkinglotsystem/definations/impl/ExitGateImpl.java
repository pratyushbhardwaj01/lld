package com.example.lld.template.parkinglotsystem.definations.impl;

import com.example.lld.template.parkinglotsystem.definations.ExitGate;
import com.example.lld.template.parkinglotsystem.models.Ticket;
import com.example.lld.template.parkinglotsystem.services.ParkingSystemService;

public class ExitGateImpl implements ExitGate {
    private int exitGateId;
    private ParkingSystemService parkingSystemService;

    public ExitGateImpl(int exitGateId, ParkingSystemService parkingSystemService) {
        this.exitGateId = exitGateId;
        this.parkingSystemService = parkingSystemService;
    }

    @Override
    public int getId() {
        return exitGateId;
    }

    public double processExit(Ticket ticket) {
        return parkingSystemService.deallocateSpace(ticket, this);

    }
}
