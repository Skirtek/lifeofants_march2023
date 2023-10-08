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
        int colonyWidth = 40;
        int colonyHeight = 20;
        AntColony colony = new AntColony(colonyWidth, colonyHeight);

        Map<Class<? extends Ant>, Integer> colonyConfiguration = new HashMap<>();
        colonyConfiguration.put(Worker.class, 40);
        colonyConfiguration.put(Soldier.class, 10);
        colonyConfiguration.put(Drone.class, 20);

        colony.generateNewColony(colonyConfiguration);


    }

    public static void main(String[] args) {
        launch();
    }
}