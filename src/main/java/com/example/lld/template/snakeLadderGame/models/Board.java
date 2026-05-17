package com.example.lld.template.snakeLadderGame.models;

import com.example.lld.template.snakeLadderGame.definations.MovingEntity;

import java.util.HashMap;

public class Board {
    private HashMap<Integer, MovingEntity> movingEntities;
    private int size;

    public Board(int size) {
        this.size = size;
        this.movingEntities = new HashMap<>();
    }

    public void addMovingEntity(MovingEntity movingEntity) {
        int startPos = movingEntity.getStartPos();
        this.movingEntities.put(startPos, movingEntity);
    }

    public int getUpdatePosition(int currentPosition) {
        MovingEntity movingEntity = this.movingEntities.get(currentPosition);
        if (movingEntity == null) {
            return currentPosition;
        }
        return movingEntity.getEndPos();
    }

    public boolean isAtLastPos(int pos) {
        return pos == this.size;
    }

    public int getBoardSize() {
        return this.size;
    }

}
