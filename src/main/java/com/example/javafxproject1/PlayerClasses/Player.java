package com.example.javafxproject1.PlayerClasses;

import com.example.javafxproject1.Figure;
import javafx.scene.image.ImageView;

public class Player {
    private String jmeno;
    private String prijmeni;
    private int plat;
    private String profese;
    private MonthlyExpenses mesicne;
    private Debts dluhy;
    private Figure figure;

    // Konstruktor
    public Player(String jmeno, String prijmeni, int plat, String profese, MonthlyExpenses mesicne, Debts dluhy, Figure figure) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.plat = plat;
        this.profese = profese;
        this.mesicne = mesicne;
        this.dluhy = dluhy;
        this.figure = figure;
    }
    public Player(String jmeno, String prijmeni, int plat, String profese, MonthlyExpenses mesicne, Debts dluhy) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.plat = plat;
        this.profese = profese;
        this.mesicne = mesicne;
        this.dluhy = dluhy;
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
}
