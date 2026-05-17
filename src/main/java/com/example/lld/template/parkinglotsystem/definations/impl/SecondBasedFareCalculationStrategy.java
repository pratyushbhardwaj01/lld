package com.example.lld.template.parkinglotsystem.definations.impl;

import com.example.lld.template.parkinglotsystem.definations.FareCalculationStrategy;
import com.example.lld.template.parkinglotsystem.models.Ticket;

import java.time.Duration;
import java.time.Instant;

public class SecondBasedFareCalculationStrategy implements FareCalculationStrategy {
    @Override
    public double calculateFare(Ticket ticket) {
        Instant entryTime = ticket.getEntryTime();
        Instant exitTime = ticket.getExitTime();
        double elapsedSeconds = Duration.between(entryTime, exitTime).getSeconds();
        return elapsedSeconds * 1.5;
    }
}
