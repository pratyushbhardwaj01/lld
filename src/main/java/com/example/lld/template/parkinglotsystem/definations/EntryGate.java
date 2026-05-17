package com.example.lld.template.parkinglotsystem.definations;

import com.example.lld.template.parkinglotsystem.models.Ticket;
import com.example.lld.template.parkinglotsystem.models.Vehicle;

public interface EntryGate extends Gate {
    public Ticket processEntry(Vehicle vehicle);
}
