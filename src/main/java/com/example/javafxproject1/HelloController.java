package com.example.javafxproject1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.scene.shape.Circle;

import java.io.File;
import java.util.Random;

public class HelloController {
    Random random = new Random();
    Dice dice;
    @FXML
    private AnchorPane storyboard;
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
    private Button rollButton;

    @FXML
    public void initialize() {
        GameEngine game = new GameEngine(player1,player2,player3,player4);
        game.launchPopUpNumberOfPlayers();

        dice = new Dice(diceImage);


        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        diceImage.setLayoutX(screenWidth-250);


        //Rectangle rectangle = new Rectangle(50, 50);
        //rectangle.setFill(Color.RED);
        //storyboard.

        diceImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Call the method you want to execute on ImageView click
                roll();
            }
        });
    }

    private void addFigure() {
        // Přidání kruhové figurky na mainPane
        Circle figure = new Circle(30, Color.BLUE);
        storyboard.getChildren().add(figure);

        // Můžete provádět další úpravy nebo nastavení pro tuto figurku zde
        // Například, můžete přidat obsluhu událostí pro kliknutí na figurku
        figure.setOnMouseClicked(event -> {
            // Zde můžete definovat akce, které se mají provést po kliknutí na figurku
            System.out.println("Figurka byla kliknuta!");
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


                    }
                    System.out.println(dice.choosingNumber());
                    diceImage.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    public void increment(ActionEvent actionEvent) {
    }

    public void decrement(ActionEvent actionEvent) {
    }
}