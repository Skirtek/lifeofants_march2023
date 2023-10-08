package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Objects;

public class Queen extends Ant {
    private static Image image;

    private static Queen instance;

    private Queen(@NonNull Position position) {
        super(position);
    }

    public static Queen getInstance(int width, int height) {
        if (instance == null) {
            instance = new Queen(new Position(width / 2, height / 2));
        }

        return instance;
    }

    @Override
    public Image getImage(double size) {
        if(Objects.isNull(image)){
            image = new Image(Drone.class.getResourceAsStream("/queen.png"), size, size, true, false);
        }

        return image;
    }
}
