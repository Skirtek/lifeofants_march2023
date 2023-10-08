package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Moveable;
import com.codecool.lifeofants.Position;
import com.codecool.lifeofants.utils.Direction;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Objects;

import static com.codecool.lifeofants.utils.Direction.getRandomMove;

public class Worker extends Ant implements Moveable {
    private static Image image;

    public Worker(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (Objects.isNull(image)) {
            image = new Image(Drone.class.getResourceAsStream("/worker.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        Position randomPosition = Direction.getRandomMove().getValue();

        int newX = getPosition().getX() + randomPosition.getX();
        int newY = getPosition().getY() + randomPosition.getY();

        return new Position(newX, newY);
    }
}
