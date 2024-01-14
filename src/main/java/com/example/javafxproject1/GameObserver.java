package com.example.javafxproject1;

public interface GameObserver {
    void onNumberOfPlayersSelected(int numberOfPlayers);
    void onShowFigure();
    void onMoveFigure(double x, double y);
}