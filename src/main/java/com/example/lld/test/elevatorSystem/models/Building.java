package com.example.lld.test.elevatorSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Building {
    int totalNumberOfFloors;
    List<Floor> floorList;

    public Building(int totalNumberOfFloors) {
        this.totalNumberOfFloors = totalNumberOfFloors;
        this.floorList = new ArrayList<>();
        for(int i = 0; i < totalNumberOfFloors; i++) {
            List<Button>buttonList = new ArrayList<>();
            for(int j = 0; j < totalNumberOfFloors; j++) {
                Button button = new Button()

            }
            Panel panel = new Panel()
            Floor floor = new Floor(i + 1)
        }
    }
}
