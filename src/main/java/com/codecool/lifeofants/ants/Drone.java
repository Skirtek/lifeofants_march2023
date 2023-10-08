package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Objects;

public class Drone extends Ant {
    private static Image image;

    public Drone(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if(Objects.isNull(image)){
            image = new Image(Drone.class.getResourceAsStream("/drone.png"), size, size, true, false);
        }

        return image;
    }
}
