package com.example.lld.template.parkinglotsystem.exceptions;

import com.example.lld.template.parkinglotsystem.enums.VehicleTypes;

public class LotFullException extends ParkingLotException {
    public LotFullException(VehicleTypes type) {
        super("No available slot for vehicle type: " + type);
    }
}
