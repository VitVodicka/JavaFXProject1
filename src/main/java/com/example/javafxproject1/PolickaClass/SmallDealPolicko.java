package com.example.javafxproject1.PolickaClass;

public class SmallDealPolicko {
    private String Description;
    private String Ticker;
    private int Price;
    private int Dividend;

    // Constructor
    public SmallDealPolicko(String description, String ticker, int price) {
        this.Description = description;
        this.Ticker = ticker;
        this.Price = price;
    }
    public SmallDealPolicko(String description, String ticker, int price,int dividend) {
        this.Description = description;
        this.Ticker = ticker;
        this.Price = price;
        this.Dividend=dividend;
    }

    // Getters
    public String getDescription() {
        return Description;
    }

    public String getTicker() {
        return Ticker;
    }

    public int getPrice() {
        return Price;
    }

    public int getDividend() {
        return Dividend;
    }


    //recognizing type after
}
