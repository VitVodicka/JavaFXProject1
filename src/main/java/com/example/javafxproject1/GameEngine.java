package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Player;
import com.example.javafxproject1.PolickaClass.BigDealPolicko;
import com.example.javafxproject1.PolickaClass.ExpensesPolicko;
import com.example.javafxproject1.PolickaClass.MarketPolicko;
import com.example.javafxproject1.PolickaClass.SmallDealPolicko;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.*;

public class GameEngine {
    private int numberOfPlayers;
    private List<Player> listPlayer;
    private ImageView player1;
    private ImageView player2;
    private ImageView player3;
    private ImageView player4;
    private List<Policko> listPolicka;
    private HelloController helloController;
    public static int PlayerTurn;



    GameEngine(ImageView player1, ImageView player2, ImageView player3, ImageView player4, HelloController helloController) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.helloController = helloController;

        listPlayer = new ArrayList<>();
        listPolicka = new ArrayList<>();

    }

    public void generatePolicka() {
        //region setting policka
        Policko policko1 = new Policko();
        policko1.setX(725);
        policko1.setY(120);
        policko1.setIsNothing(true);
        listPolicka.add(policko1);

        Policko policko2 = new Policko();
        policko2.setX(830);
        policko2.setY(120);
        policko2.setIncome(true);
        listPolicka.add(policko2);

        Policko policko3 = new Policko();
        policko3.setX(830);
        policko3.setY(225);
        policko3.setBigDeal(true);
        listPolicka.add(policko3);

        Policko policko4 = new Policko();
        policko4.setX(830);
        policko4.setY(330);
        policko4.setMarket(true);
        listPolicka.add(policko4);

        Policko policko5 = new Policko();
        policko5.setX(830);
        policko5.setY(435);
        policko5.setSmallDeal(true);
        listPolicka.add(policko5);

        Policko policko6 = new Policko();
        policko6.setX(830);
        policko6.setY(540);
        policko6.setIncome(true);
        listPolicka.add(policko6);

        Policko policko7 = new Policko();
        policko7.setX(725);
        policko7.setY(540);
        policko7.setExpanses(true);
        listPolicka.add(policko7);

        Policko policko8 = new Policko();
        policko8.setX(620);
        policko8.setY(540);
        policko8.setSmallDeal(true);
        listPolicka.add(policko8);

        Policko policko9 = new Policko();
        policko9.setX(520);
        policko9.setY(540);
        policko9.setMarket(true);
        listPolicka.add(policko9);

        Policko policko10 = new Policko();
        policko10.setX(415);
        policko10.setY(540);
        policko10.setIncome(true);
        listPolicka.add(policko10);

        Policko policko11 = new Policko();
        policko11.setX(415);
        policko11.setY(435);
        policko11.setBigDeal(true);
        listPolicka.add(policko11);

        Policko policko12 = new Policko();
        policko12.setX(415);
        policko12.setY(330);
        policko12.setLayoff(true);
        listPolicka.add(policko12);

        Policko policko13 = new Policko();
        policko13.setX(415);
        policko13.setY(225);
        policko13.setSmallDeal(true);
        listPolicka.add(policko13);

        Policko policko14 = new Policko();
        policko14.setX(415);
        policko14.setY(120);
        policko14.setIncome(true);
        listPolicka.add(policko14);

        Policko policko15 = new Policko();
        policko15.setX(520);
        policko15.setY(120);
        policko15.setExpanses(true);
        listPolicka.add(policko15);

        Policko policko16 = new Policko();
        policko16.setX(620);
        policko16.setY(120);
        policko16.setSmallDeal(true);
        listPolicka.add(policko16);
        //endregion
    }


    public void launchPopUpNumberOfPlayers() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Počet Hráčů");
        alert.setHeaderText(null);
        alert.setContentText("Zadejte počet hráčů (Max 4, Min 1):");

        TextField playerCountField = new TextField();
        playerCountField.setPromptText("Počet hráčů");

        // Přidání prvků do rozložení
        GridPane grid = new GridPane();
        grid.add(new Label("Počet hráčů:"), 0, 0);
        grid.add(playerCountField, 1, 0);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        // Přidání rozložení do dialogového okna
        alert.getDialogPane().setContent(grid);

        // Array to store the result
        boolean resaultFromLambda = false;
        final int[] result = {0};

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Získání hodnoty z pole počtu hráčů
                String playerCountText = playerCountField.getText();
                try {
                    int playerCount = Integer.parseInt(playerCountText);
                    // Zde můžete použít hodnotu 'playerCount' podle potřeby
                    if (playerCount > 0 && playerCount < 5) {
                        result[0] = playerCount;
                    } else {
                        // Handle invalid input
                        showErrorAndExit();
                    }
                } catch (NumberFormatException e) {
                    // Uživatel zadal neplatné číslo
                    e.printStackTrace();
                    showErrorAndExit();
                }
            } else {
                Platform.exit();
            }
        });

        // Return the result after the lambda expression
        numberOfPlayers = result[0];
        launchGame();
    }

    public void launchGame() {

        Figure fig1, fig2, fig3, fig4;

        int randomCislo;


        switch (numberOfPlayers) {
            case 1:
                fig1 = new Figure(player1);
                fig1.onShowFigure();

                List<Figure> figures= new ArrayList<>();
                figures.add(fig1);


                generatingUsersAndFiguresConfig(1,figures);

                fig1.setTurn(true);
                fig1.setCurrentPolickoIndex(0);
                break;
            case 2:

                fig1 = new Figure(player1);
                fig1.onShowFigure();
                fig2 = new Figure(player2);
                fig2.onShowFigure();

                fig1.setCurrentPolickoIndex(0);
                fig2.setCurrentPolickoIndex(0);

                List<Figure> figures1= new ArrayList<>();
                figures1.add(fig1);
                figures1.add(fig2);

                generatingUsersAndFiguresConfig(2,figures1);



                fig1.setTurn(true);
                break;
            case 3:

                fig1 = new Figure(player1);
                fig1.onShowFigure();
                fig2 = new Figure(player2);
                fig2.onShowFigure();
                fig3 = new Figure(player3);
                fig3.onShowFigure();

                fig1.setCurrentPolickoIndex(0);
                fig2.setCurrentPolickoIndex(0);
                fig3.setCurrentPolickoIndex(0);

                List<Figure> figures2= new ArrayList<>();
                figures2.add(fig1);
                figures2.add(fig2);
                figures2.add(fig3);

                generatingUsersAndFiguresConfig(3,figures2);



                fig1.setTurn(true);

                break;
            case 4:
                fig1 = new Figure(player1);
                fig1.onShowFigure();
                fig2 = new Figure(player2);
                fig2.onShowFigure();
                fig3 = new Figure(player3);
                fig3.onShowFigure();
                fig4 = new Figure(player4);
                fig4.onShowFigure();

                List<Figure> figures3= new ArrayList<>();
                figures3.add(fig1);
                figures3.add(fig2);
                figures3.add(fig3);
                figures3.add(fig4);

                generatingUsersAndFiguresConfig(4,figures3);

                fig1.setCurrentPolickoIndex(0);
                fig2.setCurrentPolickoIndex(0);
                fig3.setCurrentPolickoIndex(0);
                fig4.setCurrentPolickoIndex(0);





                fig1.setTurn(true);

                break;

        }

    }


    private void generatingUsersAndFiguresConfig(int numberOfPlayers, List<Figure>figurelist) {
        Files f = new Files();
        List<Player> playerListJSON = f.readUser();
        List<Integer> chosenNumbers = new ArrayList<>();

        Random random = new Random();
        int randomCislo, randomCislo2, randomCislo3;


        if (numberOfPlayers == 1) {
            randomCislo = random.nextInt(playerListJSON.size());
            var JSONShortcut = playerListJSON.get(randomCislo);

            Player pl = new Player(JSONShortcut.getJmeno(), JSONShortcut.getPrijmeni(),
                    JSONShortcut.getPlat(), JSONShortcut.getProfese(), JSONShortcut.getMesicne(), JSONShortcut.getDluhy(), figurelist.get(0),0);

            listPlayer.add(pl);
        } else {
            for (int i = 0; i < numberOfPlayers; i++) {
                do {
                    if (i == 0) {
                        randomCislo2 = random.nextInt(playerListJSON.size());
                        var JSONShortcut = playerListJSON.get(randomCislo2);

                        Player pl = new Player(JSONShortcut.getJmeno(), JSONShortcut.getPrijmeni(),
                                JSONShortcut.getPlat(), JSONShortcut.getProfese(), JSONShortcut.getMesicne(), JSONShortcut.getDluhy(), figurelist.get(i),0);

                        listPlayer.add(pl);
                        chosenNumbers.add(randomCislo2);
                        break;
                    } else {
                        randomCislo3 = random.nextInt(playerListJSON.size());
                        if (!chosenNumbers.contains(randomCislo3)) {
                            var JSONShortcut = playerListJSON.get(randomCislo3);

                            Player pl = new Player(JSONShortcut.getJmeno(), JSONShortcut.getPrijmeni(),
                                    JSONShortcut.getPlat(), JSONShortcut.getProfese(), JSONShortcut.getMesicne(), JSONShortcut.getDluhy(), figurelist.get(i),0);

                            listPlayer.add(pl);
                            chosenNumbers.add(randomCislo3);
                            break;
                        }
                    }
                }while (chosenNumbers.size() > 0) ;




            }


        }




    }

    private void showErrorAndExit() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Chybný počet hráčů");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Zadali jste neplatný vstup. Aplikace se ukončí ");

        errorAlert.showAndWait();

        // Wait for some time


        Platform.exit();
    }

    public void turnSwitching(){
        int counter=0;
        int numberOfPlayers = listPlayer.size();

        for (Player pl : listPlayer) {
            if (pl.getFigure().isTurn()) {
                if (listPlayer.size() > 1) {
                    pl.getFigure().setTurn(false); // Odeber turn od aktuálního hráče

                    if (counter < numberOfPlayers - 1) {
                        // Pokud není poslední hráč, předáme turn následujícímu hráči
                        listPlayer.get(counter + 1).getFigure().setTurn(true);
                    } else {
                        // Pokud je poslední hráč, předáme turn prvnímu hráči
                        listPlayer.get(0).getFigure().setTurn(true);
                    }

                    break; // Máme aktuálního hráče, můžeme ukončit smyčku
                }
            }
            counter++;
        }

    }

    public String turnSelection() {
        int counter = 0;
        String text = "Na tahu je hráč ";
        for (Player pl : listPlayer) {
            counter++;
            if (pl.getFigure().isTurn()) {
                text += String.valueOf(counter);
            }

        }
        return text;

    }

    public List<Player> getListPlayer() {
        return listPlayer;
    }


    public void moveFigure(int steps) {
        int counter=0;
        int turnCounter=0;
        for (Player pl : listPlayer) {
            if(listPlayer.get(counter).getFigure().isTurn()){
                turnCounter=counter;
            }
            counter++;
        }
        int currentPolickoIndex = listPlayer.get(turnCounter).getFigure().getCurrentPolickoIndex();


        for (int i = 0; i < steps; i++) {

            //if it would go over the array
            if (currentPolickoIndex == 15) {
                currentPolickoIndex = 0;
            } else {
                Policko currentPolicko = listPolicka.get(currentPolickoIndex);
                if(currentPolicko.isIncome()){
                    typeOfPolicko(currentPolickoIndex);
                }
                currentPolickoIndex++;

            }

            listPlayer.get(turnCounter).getFigure().onMoveFigure(listPolicka.get(currentPolickoIndex).getX(), listPolicka.get(currentPolickoIndex).getY());
            listPlayer.get(turnCounter).getFigure().setCurrentPolickoIndex(currentPolickoIndex);
        }



        try {
            Thread.sleep(200); // Adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeOfPolicko(currentPolickoIndex);
        GameEngine.PlayerTurn=turnCounter;
    }



    private void typeOfPolicko(int polickoindexNumber) {

        Policko currentPolicko = listPolicka.get(polickoindexNumber);
        Oppurtunity op = new Oppurtunity();


        if (currentPolicko.isBigDeal()) {
            hideProperties();


            BigDealPolicko deal = op.LoadBigDeal();

            String descr = deal.getDescription();
            String ticker = deal.getTicker();
            int price = deal.getPrice();
            int dividend = deal.getDividend();

            double yield = 0;
            try {
                yield = ((double) dividend / price) * 100;  // Calculate the yield as a percentage directly
                yield = Math.round(yield);


            } catch (ArithmeticException e) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setContentText(String.valueOf(price) + "," + String.valueOf(dividend));
                alert2.showAndWait();
            }


            hideProperties();

            helloController.showOppurtunity();
            helloController.titleLabel2.setText("Big deal");
            helloController.descriptionLabel.setText(descr);

            showproperties(helloController.property1, helloController.property2, helloController.property3, null);

            helloController.property1.setText("Cena:" + String.valueOf(price));
            helloController.property2.setText("Měsíční příjem:" + String.valueOf(dividend) + "Kč");
            helloController.property3.setText("Roční výnos :" + String.valueOf(yield) + "%");


        } else if (currentPolicko.isSmallDeal()) {
            hideProperties();
            hideProperties();

            SmallDealPolicko deal = op.LoadSmallDeal();

            String descr = deal.getDescription();
            String ticker = deal.getTicker();
            int price = deal.getPrice();
            int dividend = deal.getDividend();

            double yield = 0;
            try {
                if (deal.getDividend() > -1) {

                    yield = ((double) dividend * 12 / price) * 100;  // Calculate the yield as a percentage directly
                    yield = Math.round(yield);
                }

            } catch (ArithmeticException e) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setContentText(String.valueOf(price) + "," + String.valueOf(deal.getDividend()));
                alert2.showAndWait();
            }

            hideProperties();

            helloController.showOppurtunity();
            helloController.titleLabel2.setText("Small deal");
            helloController.descriptionLabel.setText(descr);

            helloController.property1.setText("Cena:" + String.valueOf(price) + "Kč");

            if (deal.getDividend() > 0) {
                helloController.property2.setText("Měsíční příjem:" + String.valueOf(deal.getDividend()) + "Kč");
                helloController.property3.setText("Roční výnos :" + String.valueOf(yield) + "%");
                showproperties(helloController.property1, helloController.property2, helloController.property3, null);
            } else {
                // Handle case when there is no dividend
                showproperties(helloController.property1, null, null, null);
            }

        } else if (currentPolicko.isNothing()) {
        } else if (currentPolicko.isIncome()) {
            op.LoadIncome(listPlayer.get(GameEngine.PlayerTurn));

            ObservableList<Player> observableList = FXCollections.observableArrayList(listPlayer);
            TableHandler.setCurrentMoney(helloController.currentMoney,observableList);
        } else if (currentPolicko.isMarket()) {
            hideProperties();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            MarketPolicko exp = op.LoadMarket();

            helloController.descriptionLabel.setText(exp.getDescription());
            showproperties(helloController.property1, null, null, null);

            if (exp.getAmount() != -1 && exp.getType() != null && exp.isProcent() == false) {

                helloController.property1.setText("Cena se změnila na:" + String.valueOf(exp.getAmount()) + "Kč");
                helloController.property2.setText("U aktiva:" + String.valueOf(exp.getType()));
                showproperties(helloController.property1, helloController.property2, null, null);


            } else if (exp.getAmount() != -1 && exp.getType() != null && exp.isProcent() == true) {

                helloController.property1.setText("Cena se změnila o:" + String.valueOf(exp.getAmount()) + "%");
                helloController.property2.setText("U aktiva:" + String.valueOf(exp.getType()));
                showproperties(helloController.property1, helloController.property2, null, null);

            }


            helloController.showOppurtunity();
            helloController.titleLabel2.setText("Market");


        } else if (currentPolicko.isExpanses()) {
            hideProperties();

            HelloController.isExpense =true;

            ExpensesPolicko exp = op.LoadExpenses();
            helloController.descriptionLabel.setText(exp.getDescription());
            helloController.showOppurtunity();
            helloController.titleLabel2.setText("Náklady");

            helloController.property1.setText("Cena:" + String.valueOf(exp.getAmount()) + "Kč");
            showproperties(helloController.property1, null, null, null);
            helloController.hideCancelButton();
            helloController.hideQuantityField();


        } else if (currentPolicko.isLayoff()) {
            helloController.hideCancelButton();
            helloController.hideQuantityField();

            HelloController.isLayoff =true;


        }


    }



    private void hideProperties() {
        helloController.property1.setVisible(false);
        helloController.property2.setVisible(false);
        helloController.property3.setVisible(false);
        helloController.property4.setVisible(false);


    }

    private void showproperties(Label property1, Label property2, Label property3, Label property4) {
        //Thread.sleep(100);
        if (property1 != null) {
            property1.setVisible(true);
        }
        if (property2 != null) {
            property2.setVisible(true);
        }
        if (property3 != null) {
            property3.setVisible(true);
        }
        if (property4 != null) {
            property4.setVisible(true);
        }
        helloController.showCancelButton();
        helloController.showQuantityField();
    }
    public List<Policko> getListPolicek(){
        return listPolicka;
    }



}



