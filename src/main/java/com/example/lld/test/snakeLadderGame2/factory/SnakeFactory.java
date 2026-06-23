package com.example.lld.test.snakeLadderGame2.factory;

import com.example.lld.test.snakeLadderGame2.models.MovingEntity;
import com.example.lld.test.snakeLadderGame2.models.Snake;

public class SnakeFactory implements MovingEntityFactory {
    @Override
    public MovingEntity createMovingEntity(int start, int end) {
        return new Snake(start, end);
    }
}
