package com.example.lld.template.snakeLadderGame.models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }
}
