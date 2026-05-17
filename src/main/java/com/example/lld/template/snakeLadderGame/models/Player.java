package com.example.lld.template.snakeLadderGame.models;



public class Player {
    private String id;
    private String name;
    private int currentPos;
    private int playerRank;

    public Player(String id, String name, int currentPos) {
        this.id = id;
        this.name = name;
        this.currentPos = currentPos;
        this.playerRank = -1;
    }

    public int getCurrentPos() {
        return this.currentPos;
    }

    public void updateRank(int newRank) {
        this.playerRank = newRank;
    }

    public int getRank() {
        return this.playerRank;
    }

    public void updateCurrentPosition(int newPos) {
        this.currentPos = newPos;
    }
    public String getName() {
        return this.name;
    }
}
