package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Moveable;
import com.codecool.lifeofants.Position;
import com.codecool.lifeofants.utils.Direction;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Objects;

public class Soldier extends Ant implements Moveable {
    private static Image image;
    private Direction currentDirection = Direction.UP;

    public Soldier(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if(Objects.isNull(image)){
            image = new Image(Drone.class.getResourceAsStream("/soldier.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        int newX = getPosition().getX() + currentDirection.getValue().getX();
        int newY = getPosition().getY() + currentDirection.getValue().getY();

        switch (currentDirection) {
            case UP -> currentDirection = Direction.RIGHT;
            case RIGHT -> currentDirection = Direction.DOWN;
            case DOWN -> currentDirection = Direction.LEFT;
            case LEFT -> currentDirection = Direction.UP;
        }

        return new Position(newX, newY);
    }
}
