package com.example.lld.test.snakeLadderGame2.factory;

import com.example.lld.test.snakeLadderGame2.models.MovingEntity;

public interface MovingEntityFactory {
    public MovingEntity createMovingEntity(int start, int pos);
}
