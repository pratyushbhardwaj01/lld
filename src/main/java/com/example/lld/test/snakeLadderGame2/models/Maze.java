package com.example.lld.test.snakeLadderGame2.models;

import com.example.lld.test.snakeLadderGame2.enums.MovingEntityType;
import com.example.lld.test.snakeLadderGame2.factory.MovingEntityFactoryApplication;

import java.util.HashMap;
import java.util.Map;

public class Maze {
    private final int size;
    private final Map<Integer, MovingEntity> movingEntityMap;

    public Maze(int size) {
        this.size = size;
        this.movingEntityMap = new HashMap<>();
    }

    public void addMovingEntity(int start, int end, MovingEntityType type) {
        if (start < 1 || end < 1 || start > size || end > size) {
            throw new IllegalArgumentException("Position out of bound");
        }
        if (type == MovingEntityType.SNAKE && start <= end) {
            throw new IllegalArgumentException("Snake start must be greater then end");
        }
        if (type == MovingEntityType.LADDER && start >= end) {
            throw new IllegalArgumentException("Ladder start must be less then end");
        }
        if(type == MovingEntityType.SNAKE && start >= size) {
            throw new IllegalArgumentException("Snake can be at the destination or out of board");
        }
        movingEntityMap.put(start, new MovingEntityFactoryApplication().getMovingEntity(type, start, end));
    }

    public int getSize() {
        return this.size;
    }

    public int getUpdatedPlayerPosition(int number, Player currentPlayer) {
        int updatedPosition = currentPlayer.getPos();
        if (updatedPosition + number > size) {
            return updatedPosition;
        }
        if (movingEntityMap.containsKey(updatedPosition + number)) {
            updatedPosition = movingEntityMap.get(updatedPosition + number).getEnd();
            return updatedPosition;
        }
        return updatedPosition + number;
    }

    public boolean hasReachedDestination(Player currentPlayer) {
        return currentPlayer.getPos() == size;

    }
}
