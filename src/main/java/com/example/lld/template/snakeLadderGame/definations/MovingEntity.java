package com.example.lld.template.snakeLadderGame.definations;

import com.example.lld.template.snakeLadderGame.enums.MovingEntityType;

public abstract class MovingEntity {
    private int startPos;
    private int endPos;
    private MovingEntityType type;

    public MovingEntity(int startPos, int endPos, MovingEntityType type) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.type = type;
    }

    public int getEndPos() {
        return this.endPos;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public MovingEntityType getMovingEntityType() {
        return this.type;
    }

}
