package com.example.lld.template.snakeLadderGame.models;

import com.example.lld.template.snakeLadderGame.definations.MovingEntity;
import com.example.lld.template.snakeLadderGame.enums.MovingEntityType;

public class Ladder extends MovingEntity {
    public Ladder(int startPos, int endPos, MovingEntityType type) {
        super(startPos, endPos, type);
    }
}
