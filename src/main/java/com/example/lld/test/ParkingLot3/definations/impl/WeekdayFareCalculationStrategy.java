package com.example.lld.test.ParkingLot3.definations.impl;

import com.example.lld.test.ParkingLot3.definations.FareCalculationStrategy;
import com.example.lld.test.ParkingLot3.models.Ticket;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

public class WeekdayFareCalculationStrategy implements FareCalculationStrategy {
    @Override
    public BigDecimal calculatePrice(Ticket ticket) {
        Instant entryTime = ticket.getEntryTime();
        Instant exitTime = ticket.getExitTime();
        double elapsedSeconds = Duration.between(entryTime, exitTime).getSeconds();
        int spotSize = ticket.getParkingSpot().getParkingSlotType().getParkingSlotSize();
        return new BigDecimal(elapsedSeconds).multiply(new BigDecimal(spotSize)).multiply(new BigDecimal("3"));
    }
}
