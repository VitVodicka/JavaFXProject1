package com.example.javafxproject1.PolickaClass;

public class MarketPolicko {

    private String Description;
    private int Amount;
    private String Type;
    private String End;
    private boolean IsProcent;

    public MarketPolicko(String description, int amount, String type, boolean isProcent) {
        this.Description=description;
        this.Amount = amount;
        this.Type = type;
        IsProcent = isProcent;
    }

    public MarketPolicko(String Description){
        this.Description=Description;
    }

    public String getDescription() {
        return Description;
    }

    public int getAmount() {
        return Amount;
    }

    public String getType() {
        return Type;
    }


    public boolean isProcent() {
        return IsProcent;
    }
}
