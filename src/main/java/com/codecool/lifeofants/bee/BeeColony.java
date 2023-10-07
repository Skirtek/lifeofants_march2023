package com.codecool.lifeofants.bee;

import com.codecool.lifeofants.Colony;

import java.util.List;
import java.util.Map;

public class BeeColony implements Colony<Bee> {
    @Override
    public List<Bee> getColony() {
        return null;
    }

    @Override
    public Map<Class<? extends Bee>, Integer> getInfoAboutColonyStructure() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void generateNewColony(Map<Class<? extends Bee>, Integer> colonyConfiguration) {

    }
}
