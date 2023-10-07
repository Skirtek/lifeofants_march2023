package com.codecool.lifeofants;

import com.codecool.lifeofants.ants.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AntColony colony = new AntColony(40, 20);

        Map<Class<? extends Ant>, Integer> colonyConfiguration = new HashMap<>();
        colonyConfiguration.put(Worker.class, 40);
        colonyConfiguration.put(Soldier.class, 10);
        colonyConfiguration.put(Drone.class, 20);

        colony.generateNewColony(colonyConfiguration);

        var info = colony.getInfoAboutColonyStructure();
    }

    public static void main(String[] args) {
        launch();
    }
}