package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Queen extends Ant {
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
    public Image getImage() {
        return null;
    }
}
