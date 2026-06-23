package com.example.lld.test.elevatorSystem.models;

import java.util.UUID;

public class Button {
    private final String id;
    private final int value;
    private final String displayValue;
    private boolean isActive;

    public Button(int value, String displayValue, boolean isActive) {
        this.id = UUID.randomUUID().toString();
        this.displayValue = displayValue;
        this.value = value;
        this.isActive = isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getValue() {
        return this.value;
    }
}
