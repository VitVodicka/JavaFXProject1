package com.example.javafxproject1.PolickaClass;

public class ExpensesPolicko {
    private String Description;
    private int Amount;

    public ExpensesPolicko(String description, int amount) {
        this.Description=description;
        this.Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public int getAmount() {
        return Amount;
    }
}
