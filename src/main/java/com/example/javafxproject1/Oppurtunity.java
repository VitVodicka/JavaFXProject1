package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Investments;
import com.example.javafxproject1.PlayerClasses.Player;
import com.example.javafxproject1.PolickaClass.BigDealPolicko;
import com.example.javafxproject1.PolickaClass.ExpensesPolicko;
import com.example.javafxproject1.PolickaClass.MarketPolicko;
import com.example.javafxproject1.PolickaClass.SmallDealPolicko;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.*;

public class Oppurtunity {
    static List<ExpensesPolicko> ExpensesList = new ArrayList<ExpensesPolicko>();
    static List<MarketPolicko> MarketList= new ArrayList<MarketPolicko>();
    static List<SmallDealPolicko> SmallDealList= new ArrayList<SmallDealPolicko>();
    static List<BigDealPolicko> BigDealList= new ArrayList<BigDealPolicko>();
    static int expenseAmount;

    static String ticker;
    static  int price,dividend,amount;
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
    public static void createSmallDeal(int quantity, List<Player> listPlayer, TableView<Investments> tableView,
                                       TableColumn<Investments, Integer> investAmount,
                                       TableColumn<Investments, String> investTicker,
                                       TableColumn<Investments, Integer> investPrice,
                                       TableColumn<Investments, Integer> investDividend) {

        Investments invest;
        for (Player pl : listPlayer) {
            if (pl.getFigure().isTurn()) {
                if(dividend>-1){
                    invest = new Investments(quantity,ticker,price,dividend);
                }
                else {
                    invest = new Investments(quantity,ticker,price);
                }

                // Voláme metodu MoneyLayoff na aktuálním hráči
                pl.addInvestment(invest);
                ObservableList<Investments> observableInvestmentList = FXCollections.observableArrayList(pl.getInvestmentsList());


                tableView.getItems().add(invest);
                TableHandler.setInvestmentsTable(tableView, investAmount, investTicker, investPrice, investDividend,observableInvestmentList);

                break;
            }

        }
    }



}
