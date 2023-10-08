package com.codecool.lifeofants.view;

import com.codecool.lifeofants.Animal;
import com.codecool.lifeofants.Colony;
import com.codecool.lifeofants.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;

public class ColonyCanvas<T extends Animal> {
    private final static double CANVAS_MARGIN = 5.5;

    @Getter
    private final int cellSize;

    private final GraphicsContext graphicsContext;

    @Getter
    private final Colony<T> colony;

    @Getter
    private final Canvas canvas;

    public ColonyCanvas(int cellSize, Colony<T> colony) {
        this.cellSize = cellSize;
        this.colony = colony;

        Canvas canvas = new Canvas();
        canvas.setHeight(colony.getHeight() * cellSize + CANVAS_MARGIN);
        canvas.setWidth(colony.getWidth() * cellSize + CANVAS_MARGIN);

        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    public void draw() {
        clearCanvas();
        drawLines();
        drawColony();
    }

    private void clearCanvas() {
        // clearRect(start x, start y, end x, end y)
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawLines() {
        graphicsContext.setLineWidth(2);
        graphicsContext.setStroke(Color.BLACK);

        // | | | | | |
        for (double i = 0.5; i <= (colony.getWidth() * cellSize)  + 1; i += cellSize) {
            // strokeLine(start x, start y, end x, end y)
            graphicsContext.strokeLine(i, 0, i, colony.getHeight() * cellSize);
        }

        // --------
        for (double i = 0.5; i <= (colony.getHeight() * cellSize) + 1; i += cellSize) {
            // strokeLine(start x, start y, end x, end y)
            graphicsContext.strokeLine(0, i, colony.getWidth() * cellSize, i);
        }
    }

    private void drawColony() {
        colony.getColony().forEach(ant -> {
            Image antImage = ant.getImage(cellSize);

            Position antPosition = ant.getPosition();

            double startXPosition = antPosition.getX() * cellSize;
            double startYPosition = antPosition.getY() * cellSize;

            graphicsContext.drawImage(antImage, startXPosition, startYPosition);
        });
    }
}
