package com.example.lld.test.elevatorSystem.models;

public class Floor {
    private int number;
    private Panel panel;

    public Floor(int floorNumber) {
        this.number = floorNumber;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

}
