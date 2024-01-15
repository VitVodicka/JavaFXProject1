package com.example.javafxproject1.PlayerClasses;

public class MonthlyExpenses {
    public int home_payment;
    public int car_loan;
    public int credit_card_payment;

    // Konstruktor
    public MonthlyExpenses(int home_payment, int car_loan, int credit_card_payment) {
        this.home_payment = home_payment;
        this.car_loan = car_loan;
        this.credit_card_payment = credit_card_payment;
    }
    public MonthlyExpenses() {
        // prázdný konstruktor
    }

    // Gettery a Settery

    public int getHome_payment() {
        return home_payment;
    }

    public void setHome_payment(int home_payment) {
        this.home_payment = home_payment;
    }

    public int getCar_loan() {
        return car_loan;
    }

    public void setCar_loan(int car_loan) {
        this.car_loan = car_loan;
    }

    public int getCredit_card_payment() {
        return credit_card_payment;
    }

    public void setCredit_card_payment(int credit_card_payment) {
        this.credit_card_payment = credit_card_payment;
    }
}

