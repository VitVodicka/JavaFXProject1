package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Debts;
import com.example.javafxproject1.PlayerClasses.Investments;
import com.example.javafxproject1.PlayerClasses.MonthlyExpenses;
import com.example.javafxproject1.PlayerClasses.Player;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.io.File;
import java.util.List;
import java.util.Random;

public class HelloController {
    Random random = new Random();
    Dice dice;
    GameEngine game;
    public static boolean isLayoff;
    public static boolean isExpense;
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
    TableView<Investments> playerTableInvestment;
    @FXML
    TableColumn<Investments, Integer> investAmount;
    @FXML
    TableColumn<Investments, String> investTicker;
    @FXML
    TableColumn<Investments, Integer> investPrice;
    @FXML
    TableColumn<Investments, Integer> investDividend;



    @FXML
    private Label salarydescription;

    @FXML
    private Button okbutton;
    @FXML
    private Button cancelbutton;

    @FXML
    public Label currentMoney;
    @FXML
    private Label currentExpenses;



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


        hideOppurtunity();

        List<Player> playerList = game.getListPlayer();
        ObservableList<Player> observablePlayerList = FXCollections.observableArrayList(playerList);

        TableHandler.setMonthlyTable(monthlyTable, mortgageHouseColumn, mortgageCarColumn, creditCardDebtColumn, observablePlayerList);
        TableHandler.setDebtTable(debtTable, mortgagehouse, mortgagecar, creditcarddebt, observablePlayerList);
        TableHandler.setInfoTable(infotable, nameColumn, surnameColumn, proffesionColumn, observablePlayerList);
        TableHandler.setSalary(salarydescription, observablePlayerList);
        TableHandler.setCurrentExpenses(currentExpenses, observablePlayerList);
        TableHandler.setCurrentMoney(currentMoney, observablePlayerList);


        playerTableInvestment.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                Investments selectedItem = playerTableInvestment.getSelectionModel().getSelectedItem();
                int rowIndex = playerTableInvestment.getItems().indexOf(selectedItem);

                handleDoubleClick(selectedItem, rowIndex);
            }
        });





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
                    game.turnSwitching();

                    List<Player> playerList = game.getListPlayer();
                    ObservableList<Player> observablePlayerList = FXCollections.observableArrayList(playerList);

                    TableHandler.setMonthlyTable(monthlyTable, mortgageHouseColumn, mortgageCarColumn, creditCardDebtColumn, observablePlayerList);
                    TableHandler.setDebtTable(debtTable, mortgagehouse, mortgagecar, creditcarddebt, observablePlayerList);
                    TableHandler.setInfoTable(infotable, nameColumn, surnameColumn, proffesionColumn, observablePlayerList);
                    TableHandler.setSalary(salarydescription, observablePlayerList);
                    TableHandler.setCurrentExpenses(currentExpenses, observablePlayerList);



                });



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
    private void handleDoubleClick(Investments selectedItem,int rowIndex) {
         if(selectedItem != null) {
            // Implement your logic for double-click action
             game.getListPlayer().get(GameEngine.PlayerTurn).deleteAt(rowIndex);
             List<Player> playerList = game.getListPlayer();
             ObservableList<Player> observablePlayerList = FXCollections.observableArrayList(playerList);
             TableHandler.setCurrentMoney(currentMoney, observablePlayerList);


        }
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
        int quantityint=Integer.parseInt(quantityText);


            if(quantityText=="") {

            }
            else if(isLayoff||isExpense){
                if(isExpense){
                    List<Player> playerList = game.getListPlayer();
                    ObservableList<Player> observablePlayerList = FXCollections.observableArrayList(playerList);

                    Oppurtunity.deductExpenseFromPlayer(game.getListPlayer());
                    TableHandler.setCurrentMoney(currentMoney, observablePlayerList);
                }
                hideOppurtunity();
                diceImage.setDisable(false);
            }
            if(quantityint>0) {
                Policko currentPolicko = game.getListPolicek().get(game.getListPlayer().get(GameEngine.PlayerTurn).getFigure().getCurrentPolickoIndex());

                if (currentPolicko.isSmallDeal()) {
                    Oppurtunity.createSmallDeal(quantityint, game.getListPlayer(), playerTableInvestment, investAmount, investTicker, investPrice, investDividend);


                }
            }



        HelloController.isLayoff =false;
        HelloController.isExpense =false;
        hideOppurtunity();

        diceImage.setDisable(false);


    }
    public void hideCancelButton(){
        cancelbutton.setVisible(false);

    }
    public void showCancelButton(){
        cancelbutton.setVisible(true);

    }
    public void hideQuantityField(){
        quantityField.setVisible(false);

    }
    public void showQuantityField(){
        quantityField.setVisible(true);

    }

}