package com.example.lld.template.parkinglotsystem.exceptions;

import com.example.lld.template.parkinglotsystem.models.ParkingSlot;

public class SlotAlreadyEmptyException extends ParkingLotException{
    public SlotAlreadyEmptyException(ParkingSlot parkingSlot) {
        super("The slot is already empty." + parkingSlot.getSlotId());

    }
}
