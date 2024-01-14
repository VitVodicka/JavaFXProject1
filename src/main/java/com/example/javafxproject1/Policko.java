package com.example.javafxproject1;

public class Policko {
    private int x, y;

    private boolean isSmallDeal, isIncome, isBigDeal, isMarket, isExpanses, isLayoff,isNothing;

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSmallDeal() {
        return isSmallDeal;
    }
    public boolean isNothing() {
        return isNothing;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public boolean isBigDeal() {
        return isBigDeal;
    }

    public boolean isMarket() {
        return isMarket;
    }

    public boolean isExpanses() {
        return isExpanses;
    }

    public boolean isLayoff() {
        return isLayoff;
    }


    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSmallDeal(boolean smallDeal) {
        isSmallDeal = smallDeal;
    }
    public void setIsNothing(boolean isNothing) {
        this.isNothing = isNothing;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public void setBigDeal(boolean bigDeal) {
        isBigDeal = bigDeal;
    }

    public void setMarket(boolean market) {
        isMarket = market;
    }

    public void setExpanses(boolean expanses) {
        isExpanses = expanses;
    }

    public void setLayoff(boolean layoff) {
        isLayoff = layoff;
    }
}

