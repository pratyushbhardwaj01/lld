package com.example.lld.test.ParkingLot3.definations;

import com.example.lld.test.ParkingLot3.models.Ticket;

import java.math.BigDecimal;

public interface FareCalculationStrategy {
    public BigDecimal calculatePrice(Ticket ticket);
}
