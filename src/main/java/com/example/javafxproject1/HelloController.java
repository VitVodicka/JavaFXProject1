package com.example.javafxproject1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.scene.shape.Circle;

import java.io.File;
import java.util.Random;

public class HelloController {
    Random random = new Random();
    Dice dice;
    GameEngine game;
    @FXML
    private AnchorPane storyboard;
    @FXML
    private Label titleLabel;

    @FXML
    private ImageView diceImage;

    //figure declaration
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private ImageView player3;
    @FXML
    private ImageView player4;

    @FXML
    private StackPane oppurtunitypane;

    @FXML
    private TextField quantityField;
    @FXML
    public Label descriptionLabel;

    @FXML
    public Label property1;
    @FXML
    public Label property2;
    @FXML
    public Label property3;
    @FXML
    public Label property4;



    @FXML
    private Button rollButton;
    @FXML
    public Label titleLabel2;

    @FXML
    public void initialize() {
        game = new GameEngine(player1,player2,player3,player4,this);
        game.launchPopUpNumberOfPlayers();

        dice = new Dice(diceImage);


        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        diceImage.setLayoutX(screenWidth-250);


        //hideOppurtunity();
        game.generatePolicka();

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

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running");
            try {
                for (int i = 0; i < 15; i++) {
                    File file = new File("src/main/resources/dice-" + (random.nextInt(6) + 1) + ".png");
                    Image image = new Image(file.toURI().toString());

                    // Update UI on the JavaFX Application Thread
                    Platform.runLater(() -> diceImage.setImage(image));
                    Thread.sleep(50);
                }

                // Enable diceImage on the JavaFX Application Thread
                Platform.runLater(() -> diceImage.setDisable(false));

                // Update UI on the JavaFX Application Thread after the animation
                Platform.runLater(() -> {
                    titleLabel.setText(game.turnSelection());
                    game.moveFigure(dice.choosingNumber());

                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
    @FXML
    public void hideOppurtunity(){
        oppurtunitypane.setVisible(false);
        diceImage.setDisable(false);

    }
    public void showOppurtunity(){
        oppurtunitypane.setVisible(true);
        diceImage.setDisable(true);
    }

    @FXML
    public void OKhideOppurtunity(ActionEvent actionEvent) {
        String quantityText = quantityField.getText();

            try {
                int quantityint=Integer.parseInt(quantityText);
                if(quantityint>0){
                    hideOppurtunity();
                    diceImage.setDisable(false);
                }
                else {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Nejsou peníze nebo špatný formát");
                    al.showAndWait();
                }

            } catch (NumberFormatException e) {
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setContentText("Nejsou peníze nebo špatný formát");
                al.showAndWait();
            }

    }
}