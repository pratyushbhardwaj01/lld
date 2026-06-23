package com.example.lld.test.snakeLadderGame2.models;

public abstract class MovingEntity {
    private final int start;
    private final int end;

    public MovingEntity(int start, int end) {
        this.end = end;
        this.start = start;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
