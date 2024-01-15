package com.example.javafxproject1.PlayerClasses;

public class Debts {
    private int home_debt;
    private int car_debt;
    private int credit_card_debt;

    // Konstruktor
    public Debts(int home_debt, int car_debt, int credit_card_debt) {
        this.home_debt = home_debt;
        this.car_debt = car_debt;
        this.credit_card_debt = credit_card_debt;
    }

    // Gettery a Settery

    public int getHome_debt() {
        return home_debt;
    }

    public void setHome_debt(int home_debt) {
        this.home_debt = home_debt;
    }

    public int getCar_debt() {
        return car_debt;
    }

    public void setCar_debt(int car_debt) {
        this.car_debt = car_debt;
    }

    public int getCredit_card_debt() {
        return credit_card_debt;
    }

    public void setCredit_card_debt(int credit_card_debt) {
        this.credit_card_debt = credit_card_debt;
    }
}

