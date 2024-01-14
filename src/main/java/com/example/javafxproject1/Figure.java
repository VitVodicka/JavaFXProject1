package com.example.javafxproject1;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Figure implements GameObserver {
    private int totalIncome, totalExpenses,payday;
    private ImageView figure;
    private int currentPolickoIndex;

    private Policko currentPolicko;

    private boolean isTurn;

    Figure(ImageView figure){
        this.figure=figure;
    }
    @Override
    public void onNumberOfPlayersSelected(int numberOfPlayers) {

    }

    @Override
    public void onShowFigure() {
        figure.setVisible(true);

    }

    @Override
    public void onMoveFigure(double x, double y) {
        figure.setLayoutX(x);
        figure.setLayoutY(y);
    }


    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public int getCurrentPolickoIndex() {
        return currentPolickoIndex;
    }

    public void setCurrentPolickoIndex(int currentPolickoIndex) {
        this.currentPolickoIndex = currentPolickoIndex;
    }

    public Node getImageView() {
        return figure;
    }
}
