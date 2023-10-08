package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Moveable;
import com.codecool.lifeofants.Position;
import com.codecool.lifeofants.utils.Direction;
import com.codecool.lifeofants.utils.Vector;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Objects;

public class Drone extends Ant implements Moveable {
    private static Image image;
    private final int colonyWidth, colonyHeight;


    public Drone(@NonNull Position position, int colonyWidth, int colonyHeight) {
        super(position);
        this.colonyHeight = colonyHeight;
        this.colonyWidth = colonyWidth;
    }



    @Override
    public Image getImage(double size) {
        if (Objects.isNull(image)) {
            image = new Image(Drone.class.getResourceAsStream("/drone.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        Queen queen = Queen.getInstance(colonyWidth, colonyHeight);
        Position queenPosition = queen.getPosition();
        Position myPosition = this.getPosition();
        Vector vector
                = new Vector(myPosition.getX() - queenPosition.getX(), myPosition.getY() - queenPosition.getY());
        Direction nextDirection;
        if (vector.getY() == 0) {
            nextDirection = vector.getX() > 0 ? Direction.LEFT : Direction.RIGHT;
        } else {
            nextDirection = vector.getY() > 0 ? Direction.DOWN : Direction.UP;
        }
        int newX = getPosition().getX() + nextDirection.getValue().getX();
        int newY = getPosition().getY() + nextDirection.getValue().getY();
        return new Position(newX, newY);
    }
}
