package com.example.javafxproject1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;

import java.io.File;
import java.util.Random;

public class HelloController {
    Random random = new Random();

    @FXML
    private ImageView diceImage;

    @FXML
    private Button rollButton;

    @FXML
    public void initialize() {
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        diceImage.setLayoutX(screenWidth-250);
        diceImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Call the method you want to execute on ImageView click
                roll();
            }
        });
    }

    @FXML
    void roll() {
        diceImage.setDisable(true);
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 15; i++) {
                        File file = new File("src/main/resources/dice-" + (random.nextInt(6)+1)+".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                        diceImage.setDisable(false);
                    }
                    rollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}