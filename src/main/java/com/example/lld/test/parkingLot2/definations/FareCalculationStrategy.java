package com.example.lld.test.parkingLot2.definations;

import com.example.lld.test.parkingLot2.models.Ticket;

import java.math.BigDecimal;
import java.time.Instant;

public interface FareCalculationStrategy {
    public BigDecimal calculateFare(Ticket ticket);
}
