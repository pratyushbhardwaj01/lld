package com.example.lld.template.parkinglotsystem.definations;

import com.example.lld.template.parkinglotsystem.models.Ticket;

public interface ExitGate extends Gate {
    public double processExit(Ticket ticket);
}
