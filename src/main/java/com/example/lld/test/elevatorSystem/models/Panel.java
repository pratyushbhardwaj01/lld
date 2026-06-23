package com.example.lld.test.elevatorSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Panel {
    String id;
    List<Button> buttonList;
    public Panel() {
        this.id = UUID.randomUUID().toString();
        this.buttonList = new ArrayList<>();
    }
}
