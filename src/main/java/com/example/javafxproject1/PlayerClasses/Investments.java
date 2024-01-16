package com.example.javafxproject1.PlayerClasses;

public class Investments {
    private String Ticker;
    private int Price;
    private int Dividend;
    private int Amount;

    // Constructor
    public Investments(int amount, String ticker, int price) {

        this.Ticker = ticker;
        this.Price = price;
        Amount=amount;
    }
    public Investments(int amount, String ticker, int price,int dividend) {

        this.Ticker = ticker;
        this.Price = price;
        this.Dividend=dividend;
        Amount=amount;
    }

    // Getters


    public String getTicker() {
        return Ticker;
    }

    public int getPrice() {
        return Price;
    }

    public int getDividend() {
        return Dividend;
    }

    public int getAmount() {
        return Amount;
    }

}
