package com.codecool.lifeofants;

import com.codecool.lifeofants.ants.*;
import com.codecool.lifeofants.view.ColonyCanvas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    private static final int COLONY_CANVAS_MARGIN = 50;

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

        int cellSize = 32;
        ColonyCanvas<Ant> antColonyCanvas = new ColonyCanvas<>(cellSize, colony);
        antColonyCanvas.draw();

        Canvas canvas = antColonyCanvas.getCanvas();
        canvas.setLayoutX(200);
        canvas.setLayoutY(10);

        Button updateButton = new Button("Update colony");
        updateButton.setOnMouseClicked(mouseEvent -> updateColony(colony, antColonyCanvas));

        Pane leftMenuPane = new Pane();
        leftMenuPane.getChildren().addAll(updateButton);
        leftMenuPane.setLayoutX(10);
        leftMenuPane.setLayoutY(10);

        Pane mainPanel = new Pane();
        mainPanel.getChildren().addAll(canvas, leftMenuPane);

        Scene scene = new Scene(mainPanel, (colonyWidth * cellSize) + COLONY_CANVAS_MARGIN, (colonyHeight * cellSize) + COLONY_CANVAS_MARGIN);
        stage.setTitle("Life of ants - CodeCool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void updateColony(Colony<Ant> colony, ColonyCanvas<Ant> antColonyCanvas){
        colony.update();
        antColonyCanvas.draw();
    }
}