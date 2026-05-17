package com.example.lld.template.parkinglotsystem.exceptions;

import com.example.lld.template.parkinglotsystem.models.ParkingSlot;

public class SlotAlreadyOccupiedException extends ParkingLotException {
    public SlotAlreadyOccupiedException(ParkingSlot parkingSlot) {
        super("The parking slot is already occupied." + parkingSlot.getSlotId());
    }
}
