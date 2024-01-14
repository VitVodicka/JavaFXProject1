package com.example.javafxproject1;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.*;

public class GameEngine {
    private int numberOfPlayers;
    private List<Figure> listFigures;
    private ImageView player1;
    private ImageView player2;
    private ImageView player3;
    private ImageView player4;
    GameEngine(ImageView player1,ImageView player2,ImageView player3,ImageView player4){
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
        this.player4=player4;

        listFigures= new ArrayList<>();

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
        boolean resaultFromLambda=false;
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
        numberOfPlayers=result[0];
        launchGame();
    }
    public void launchGame(){
        Figure fig1,fig2,fig3,fig4;

        switch (numberOfPlayers){
            case 1:
                fig1 = new Figure(player1);
                fig1.onShowFigure();

                listFigures.add(fig1);
                break;
            case 2:
                fig1 = new Figure(player1);
                fig1.onShowFigure();
                fig2 = new Figure(player2);
                fig2.onShowFigure();

                listFigures.add(fig1);
                listFigures.add(fig2);
                break;
            case 3:
                fig1 = new Figure(player1);
                fig1.onShowFigure();
                fig2 = new Figure(player2);
                fig2.onShowFigure();
                fig3 = new Figure(player3);
                fig3.onShowFigure();

                listFigures.add(fig1);
                listFigures.add(fig2);
                listFigures.add(fig3);

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

                listFigures.add(fig1);
                listFigures.add(fig2);
                listFigures.add(fig3);
                listFigures.add(fig4);
                break;

        };
    };

    private void showErrorAndExit() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Chybný počet hráčů");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("Zadali jste neplatný vstup. Aplikace se ukončí ");

        errorAlert.showAndWait();

        // Wait for some time


        Platform.exit();
    }
}

