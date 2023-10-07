package com.codecool.lifeofants;

import com.codecool.lifeofants.ants.Ant;

import java.util.List;
import java.util.Map;

public interface Colony<T extends Animal> {
    List<T> getColony();

    Map<Class<? extends T>, Integer> getInfoAboutColonyStructure();

    void update();

    void generateNewColony(Map<Class<? extends T>, Integer> colonyConfiguration);

    default int getWidth() { return 40; }

    default int getHeight() { return 20; }
}