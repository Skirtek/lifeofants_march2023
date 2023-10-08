package com.codecool.lifeofants;

import javafx.scene.image.Image;

public interface Animal {
    Position getPosition();
    void setPosition(Position position);
    Image getImage(double size);
}
