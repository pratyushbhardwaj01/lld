package com.example.lld.test.snakeLadderGame2.factory;

import com.example.lld.test.snakeLadderGame2.enums.MovingEntityType;
import com.example.lld.test.snakeLadderGame2.models.MovingEntity;

public class MovingEntityFactoryApplication {

    public MovingEntity getMovingEntity(MovingEntityType type, int start, int end) {
        return switch (type) {
            case SNAKE -> new SnakeFactory().createMovingEntity(start, end);
            case LADDER -> new LadderFactory().createMovingEntity(start, end);
            default -> throw new IllegalArgumentException("Moving Entity type does not exist");
        };
    }
}
