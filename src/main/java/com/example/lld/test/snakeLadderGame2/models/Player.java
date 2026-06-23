package com.example.lld.test.snakeLadderGame2.models;

import java.util.UUID;

public class Player {
    private final String name;
    private final String id;
    private int pos;
    private int rank = -1;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.pos = 0;
    }

    public int getPos() {
        return this.pos;
    }

    public void setCurrentPosition(int newPosition) {
        this.pos = newPosition;
    }

    public String getName() {
        return this.name;
    }

    public void setRank(int newRank) {
        this.rank = newRank;
    }

    public int getRank() {
        return this.rank;
    }
}
