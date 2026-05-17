package com.example.lld.template.parkinglotsystem.definations;

import com.example.lld.template.parkinglotsystem.models.Ticket;

public interface FareCalculationStrategy {
     double calculateFare(Ticket ticket);
}
