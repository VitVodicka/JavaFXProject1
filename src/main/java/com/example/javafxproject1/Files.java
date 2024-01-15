package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Debts;
import com.example.javafxproject1.PlayerClasses.MonthlyExpenses;
import com.example.javafxproject1.PlayerClasses.Player;
import com.example.javafxproject1.PolickaClass.BigDealPolicko;
import com.example.javafxproject1.PolickaClass.ExpensesPolicko;
import com.example.javafxproject1.PolickaClass.MarketPolicko;
import com.example.javafxproject1.PolickaClass.SmallDealPolicko;
import com.example.javafxproject1.statement.Expenses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Files {
    public List<ExpensesPolicko> readExpanses() {
        List<ExpensesPolicko> expensesPolickoList = new ArrayList<ExpensesPolicko>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/javafxproject1/Data/Expenses.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    try {
                        int amount = Integer.parseInt(fields[0].trim());
                        String description = fields[1].trim();
                        ExpensesPolicko policko = new ExpensesPolicko(description, amount);
                        expensesPolickoList.add(policko);
                    } catch (NumberFormatException e) {
                        // Ignoruj chybný záznam
                        System.err.println("Chybný záznam: " + line);
                    }
                } else {
                    // Ignoruj chybný záznam
                    System.err.println("Chybný záznam: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return expensesPolickoList;
    }

    public List<MarketPolicko> readMarket() {
        List<MarketPolicko> marketPolickoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/javafxproject1/Data/Market.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                if (!fields[0].contains(":")) {
                    String description = fields[0];
                    MarketPolicko policko = new MarketPolicko(description);
                    marketPolickoList.add(policko);
                } else {
                    String[] subFields = fields[0].split(":");

                    if (subFields.length == 2) {


                    } if (subFields.length == 3) {
                        if (subFields[0].contains("%")) {
                            Integer amount = Integer.parseInt(subFields[1]);
                            MarketPolicko policko = new MarketPolicko(subFields[0], amount, subFields[2], true);
                            marketPolickoList.add(policko);
                        }
                        if (subFields[0].contains("Kč")) {
                            Integer amount = Integer.parseInt(subFields[1]);
                            MarketPolicko policko = new MarketPolicko(subFields[0], amount, subFields[2], false);
                            marketPolickoList.add(policko);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return marketPolickoList;
    }


    public List<SmallDealPolicko> readSmallDeal() {
        List<SmallDealPolicko> smallDealPolickoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/javafxproject1/Data/SmallDeal.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                String[] subFields = fields[0].split(":");
                if (subFields.length >= 3) {
                    String description = subFields[0];
                    int price = Integer.parseInt(subFields[1]);
                    String ticker = subFields[2];

                    if (subFields.length == 3) {
                        // Case without dividend
                        SmallDealPolicko policko = new SmallDealPolicko(description, ticker, price);
                        smallDealPolickoList.add(policko);
                    } else if (subFields.length == 4) {
                        // Case with dividend
                        int dividend = Integer.parseInt(subFields[3]);
                        SmallDealPolicko policko = new SmallDealPolicko(description, ticker, price, dividend);
                        smallDealPolickoList.add(policko);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return smallDealPolickoList;
    }
    public List<BigDealPolicko> readBigDeal() {
        List<BigDealPolicko> BigDealPolickoList = new ArrayList<BigDealPolicko>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/javafxproject1/Data/BigDeal.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                String[] subFields = fields[0].split(":");
                if (subFields.length >= 3) {
                    String description = subFields[0];
                    int price = Integer.parseInt(subFields[1]);
                    String ticker = subFields[2];

                    if (subFields.length == 4) {
                        // Case with dividend
                        int dividend = Integer.parseInt(subFields[3]);
                        BigDealPolicko policko = new BigDealPolicko(description, ticker, price, dividend);
                        BigDealPolickoList.add(policko);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BigDealPolickoList;
    }
    public List<Player> readUser(){
        JSONParser parser = new JSONParser();
        // Seznam pro ukládání objektů třídy Player
        List<Player> players = new ArrayList<Player>();

        try {
            // Čtení JSON souboru
            Object obj = parser.parse(new FileReader("src/main/java/com/example/javafxproject1/Data/Proffesion.json"));

            // Převod na JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            // Získání pole "uzivatele"
            JSONArray uzivatele = (JSONArray) jsonObject.get("uzivatele");



            // Pro každého uživatele
            for (Object o : uzivatele) {
                JSONObject user = (JSONObject) o;

                // Získání hodnot pro vytvoření objektu Player
                String jmeno = (String) user.get("jmeno");
                String prijmeni = (String) user.get("prijmeni");
                int plat = ((Long) user.get("plat")).intValue();
                String profese = (String) user.get("profese");

                // Získání objektů "mesicne" a "dluhy"
                JSONObject mesicne = (JSONObject) user.get("mesicne");
                JSONObject dluhy = (JSONObject) user.get("dluhy");

                // Vytvoření objektů tříd MonthlyExpenses a Debts
                MonthlyExpenses monthlyExpenses = new MonthlyExpenses(
                        ((Long) mesicne.get("home_payment")).intValue(),
                        ((Long) mesicne.get("car_loan")).intValue(),
                        ((Long) mesicne.get("credit_card_payment")).intValue()
                );

                Debts debts = new Debts(
                        ((Long) dluhy.get("home_debt")).intValue(),
                        ((Long) dluhy.get("car_debt")).intValue(),
                        ((Long) dluhy.get("credit_card_debt")).intValue()
                );

                // Vytvoření objektu Player
                Player player = new Player(jmeno, prijmeni, plat, profese, monthlyExpenses, debts);

                // Přidání objektu do seznamu
                players.add(player);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

}
