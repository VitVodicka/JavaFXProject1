package com.example.javafxproject1;

import javafx.scene.image.ImageView;

public class Figure implements GameObserver {
    private int totalIncome, totalExpenses,payday;
    private ImageView figure;

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

    }


    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
