package com.example.javafxproject1.PlayerClasses;

import com.example.javafxproject1.Figure;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String jmeno;
    private String prijmeni;
    private int plat;
    private String profese;
    private MonthlyExpenses mesicne;
    private Debts dluhy;
    private Figure figure;
    private int currentExpenses;
    private int surplus;
    private int CurrentMoney;
    private List<Investments> investmentsList;


    // Konstruktor
    public Player(String jmeno, String prijmeni, int plat, String profese, MonthlyExpenses mesicne, Debts dluhy, Figure figure,int currentMoney) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.plat = plat;
        this.profese = profese;
        this.mesicne = mesicne;
        this.dluhy = dluhy;
        this.figure = figure;
        CurrentMoney=currentMoney;

        currentExpenses=this.mesicne.getCar_loan()+this.mesicne.getCredit_card_payment()+this.mesicne.getHome_payment();
        surplus=this.plat-currentExpenses;

        this.investmentsList = new ArrayList<>();

    }
    public Player(String jmeno, String prijmeni, int plat, String profese, MonthlyExpenses mesicne, Debts dluhy,int currentMoney) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.plat = plat;
        this.profese = profese;
        this.mesicne = mesicne;
        this.dluhy = dluhy;
        currentExpenses=this.mesicne.getCar_loan()+this.mesicne.getCredit_card_payment()+this.mesicne.getHome_payment();
        surplus=this.plat-currentExpenses;
        CurrentMoney=currentMoney;

    }
    public Player(String jmeno, String prijmeni, String profese) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.profese = profese;
    }

    // Gettery a Settery

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public String getProfese() {
        return profese;
    }

    public void setProfese(String profese) {
        this.profese = profese;
    }

    public MonthlyExpenses getMesicne() {
        return mesicne;
    }

    public void setMesicne(MonthlyExpenses mesicne) {
        this.mesicne = mesicne;
    }

    public Debts getDluhy() {
        return dluhy;
    }

    public void setDluhy(Debts dluhy) {
        this.dluhy = dluhy;
    }

    public Figure getFigure() {
        return figure;
    }


    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public int getSurplus() {
        return surplus;
    }

    public int getCurrentMoney() {
        return CurrentMoney;
    }

    public void addIncomeMoney() {
        CurrentMoney+=surplus;
    }
    public void subtractMoney(int amount){
        CurrentMoney-=amount;
    }
    public List<Investments> getInvestmentsList(){
        return investmentsList;
    }
    public void MoneyLayoff(){
        CurrentMoney-=(2*currentExpenses);
    }
    public void addInvestment(Investments investment) {
        investmentsList.add(investment);
    }
}
