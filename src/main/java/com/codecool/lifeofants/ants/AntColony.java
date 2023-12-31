package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Colony;
import com.codecool.lifeofants.Moveable;
import com.codecool.lifeofants.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class AntColony implements Colony<Ant> {
    private final static Random random = new Random();

    @Getter
    private final int width, height;

    @Getter
    private final List<Ant> colony = new ArrayList<>();

    @Override
    public Map<Class<? extends Ant>, Integer> getInfoAboutColonyStructure() {
        Map<Class<? extends Ant>, Integer> result = new HashMap<>();

        int droneAmount = (int) colony.stream().filter(ant -> ant instanceof Drone).count();
        int workerAmount = (int) colony.stream().filter(ant -> ant instanceof Worker).count();
        int soldierAmount = (int) colony.stream().filter(ant -> ant instanceof Soldier).count();

 /*       for (Ant ant : colony) {
            if (ant instanceof Drone) {
                droneAmount++;
                continue;
            }

            if (ant instanceof Worker) {
                workerAmount++;
                continue;
            }

            if (ant instanceof Soldier) {
                soldierAmount++;
            }
        }*/

        result.put(Queen.class, 1);
        result.put(Drone.class, droneAmount);
        result.put(Worker.class, workerAmount);
        result.put(Soldier.class, soldierAmount);

        return result;
    }

    @Override
    public void update() {
        colony.forEach(ant -> {
            if (ant instanceof Queen) {
                return;
            }
            boolean isMoveFound = false;
            if (ant instanceof Moveable moveableAnt) {
                do {
                    Position nextPosition = moveableAnt.getNextPosition();
                    if (isMoveInsideColony(nextPosition)) {
                        ant.setPosition(nextPosition);
                        isMoveFound = true;
                    }
                }
                while (!isMoveFound);
            }
        });

    }

    private boolean isMoveInsideColony(Position positionToCheck) {
        return positionToCheck.getX() < this.width
                && positionToCheck.getX() > 0
                && positionToCheck.getY() < this.height
                && positionToCheck.getY() > 0;
    }

    // Drone.class: 20
    // Soldier.class: 10
    // Worker.class: 70

    // WoodenAnt.class: 10
    @Override
    public void generateNewColony(Map<Class<? extends Ant>, Integer> colonyConfiguration) {
        colony.add(Queen.getInstance(width, height));

        colonyConfiguration.forEach((antTypeClass, antAmount) -> {
            // 20
            // 0 1 2 ... 19
            // new Drone0(), new Drone1(), ... new Drone19()
            if (antTypeClass.equals(Drone.class)) {
                IntStream.range(0, antAmount).forEach(ant -> colony.add(new Drone(generateRandomAntPosition(), width, height)));
            } else if (antTypeClass.equals(Worker.class)) {
                IntStream.range(0, antAmount).forEach(ant -> colony.add(new Worker(generateRandomAntPosition())));
            } else if (antTypeClass.equals(Soldier.class)) {
                IntStream.range(0, antAmount).forEach(ant -> colony.add(new Soldier(generateRandomAntPosition())));
            } else {
                throw new IllegalArgumentException(String.format("Ant %s is not supported!", antTypeClass.getSimpleName()));
            }
        });
    }

    private Position generateRandomAntPosition() {
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        return new Position(x, y);
    }
}