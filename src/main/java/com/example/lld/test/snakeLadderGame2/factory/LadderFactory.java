package com.example.lld.test.snakeLadderGame2.factory;

import com.example.lld.test.snakeLadderGame2.models.Ladder;
import com.example.lld.test.snakeLadderGame2.models.MovingEntity;

public class LadderFactory implements MovingEntityFactory{
    @Override
    public MovingEntity createMovingEntity(int start, int end) {
        return new Ladder(start, end);

    }
}
