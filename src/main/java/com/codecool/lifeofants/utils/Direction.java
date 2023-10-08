package com.codecool.lifeofants.utils;

import com.codecool.lifeofants.Position;

import java.util.Random;

import static java.lang.Math.random;

public enum Direction {

    RIGHT(new Position(1, 0)),
    DOWN(new Position(0, -1)),
    LEFT(new Position(-1, 0)),
    UP(new Position(0, 1));

    private final Position direction;

    Direction(Position direction) {
        this.direction = direction;
    }

    public Position getValue() {
        return direction;
    }
    public static Direction getRandomMove() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}