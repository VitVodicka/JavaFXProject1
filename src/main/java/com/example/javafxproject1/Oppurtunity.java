package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Player;
import com.example.javafxproject1.PolickaClass.BigDealPolicko;
import com.example.javafxproject1.PolickaClass.ExpensesPolicko;
import com.example.javafxproject1.PolickaClass.MarketPolicko;
import com.example.javafxproject1.PolickaClass.SmallDealPolicko;

import java.util.*;

public class Oppurtunity {
    static List<ExpensesPolicko> ExpensesList = new ArrayList<ExpensesPolicko>();
    static List<MarketPolicko> MarketList= new ArrayList<MarketPolicko>();
    static List<SmallDealPolicko> SmallDealList= new ArrayList<SmallDealPolicko>();
    static List<BigDealPolicko> BigDealList= new ArrayList<BigDealPolicko>();
    static int expenseAmount;
    public void LoadIncome(Player pl){
        pl.addIncomeMoney();

    }
    public BigDealPolicko LoadBigDeal(){
        if (BigDealList.isEmpty()) {
            Files f = new Files();
            BigDealList = f.readBigDeal();
        }

        int randomIndex = new Random().nextInt(BigDealList.size());
        return BigDealList.get(randomIndex);
    }
    public SmallDealPolicko LoadSmallDeal(){
        if (SmallDealList.isEmpty()) {
            Files f = new Files();
            SmallDealList = f.readSmallDeal();
        }

        int randomIndex = new Random().nextInt(SmallDealList.size());
        return SmallDealList.get(randomIndex);
    }
    public MarketPolicko LoadMarket(){
        if (MarketList.isEmpty()) {
            Files f = new Files();
            MarketList = f.readMarket();
        }

        int randomIndex = new Random().nextInt(MarketList.size());
        return MarketList.get(randomIndex);
    }

    public ExpensesPolicko LoadExpenses() {
        if (ExpensesList.isEmpty()) {
            Files f = new Files();
            ExpensesList = f.readExpanses();
        }

        int randomIndex = new Random().nextInt(ExpensesList.size());
        return ExpensesList.get(randomIndex);
    }


    public static void deductExpenseFromPlayer(List<Player> listPlayer) {
        int turnCounter = 0;

        for (Player pl : listPlayer) {
            if (listPlayer.get(turnCounter).getFigure().isTurn()) {
                // Voláme metodu MoneyLayoff na aktuálním hráči
                pl.subtractMoney(Oppurtunity.expenseAmount);
                break;
            }
            turnCounter++;
        }
    }



}
