package com.example.lld.test.parkingLot2.definations.impl;

import com.example.lld.test.parkingLot2.definations.FareCalculationStrategy;
import com.example.lld.test.parkingLot2.models.Ticket;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

public class PeakTimeFareStrategy implements FareCalculationStrategy {
    @Override
    public BigDecimal calculateFare(Ticket ticket) {
        Instant entryTime = ticket.getEntryTime();
        Instant exitTime = ticket.getExitTime();
        long duration = Duration.between(entryTime, exitTime).toSeconds();
        BigDecimal spotSize = new BigDecimal(ticket.getSpot().getType().getSize());
        return new BigDecimal(duration).multiply(spotSize).multiply(new BigDecimal(2));
    }
}
