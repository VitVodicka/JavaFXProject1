package com.example.javafxproject1;

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
}
