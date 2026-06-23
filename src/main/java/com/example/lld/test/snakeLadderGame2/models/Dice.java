package com.example.lld.test.snakeLadderGame2.models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int sides = 6;

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }
}
