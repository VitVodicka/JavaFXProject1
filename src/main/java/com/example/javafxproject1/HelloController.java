package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Debts;
import com.example.javafxproject1.PlayerClasses.MonthlyExpenses;
import com.example.javafxproject1.PlayerClasses.Player;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.List;
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
    private TableView<MonthlyExpenses> monthlyTable;


    @FXML
    private TableColumn<MonthlyExpenses, Integer> mortgageHouseColumn;

    @FXML
    private TableColumn<MonthlyExpenses, Integer> mortgageCarColumn;

    @FXML
    private TableColumn<MonthlyExpenses, Integer> creditCardDebtColumn;


    @FXML
    private TableView<Debts> debtTable;

    @FXML
    private TableColumn<Debts, Integer> mortgagehouse;

    @FXML
    private TableColumn<Debts, Integer> mortgagecar;

    @FXML
    private TableColumn<Debts, Integer> creditcarddebt;


    @FXML
    private TableView<Player> infotable;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, String> surnameColumn;

    @FXML
    private TableColumn<Player, String> proffesionColumn;

    @FXML
    private Label salarydescription;




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



        game.generatePolicka();



        //salarydescription.setText(String.valueOf(playerInfoData.get(0).getPlat()));
        List<Player> playerList = game.getListPlayer();
        ObservableList<Player> observablePlayerList = FXCollections.observableArrayList(playerList);

        TableHandler.initializeMonthlyTable(monthlyTable, mortgageHouseColumn, mortgageCarColumn, creditCardDebtColumn, observablePlayerList);
        TableHandler.initializeDebtTable(debtTable, mortgagehouse, mortgagecar, creditcarddebt, observablePlayerList);
        TableHandler.initializeInfoTable(infotable, nameColumn, surnameColumn, proffesionColumn, observablePlayerList);
        TableHandler.initializeSalary(salarydescription, playerList.get(0));






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