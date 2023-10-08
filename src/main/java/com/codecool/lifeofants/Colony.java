package com.codecool.lifeofants;

import java.util.List;
import java.util.Map;

public interface Colony<T extends Animal> {
    List<T> getColony();

    // Drone.class: 20
    // Soldier.class: 10
    // Worker.class: 70
    Map<Class<? extends T>, Integer> getInfoAboutColonyStructure();

    void update();

    void generateNewColony(Map<Class<? extends T>, Integer> colonyConfiguration);

    default int getWidth() { return 40; }

    default int getHeight() { return 20; }
}