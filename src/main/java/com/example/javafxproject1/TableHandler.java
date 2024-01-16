package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Debts;
import com.example.javafxproject1.PlayerClasses.Investments;
import com.example.javafxproject1.PlayerClasses.MonthlyExpenses;
import com.example.javafxproject1.PlayerClasses.Player;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableHandler {

    public static void setMonthlyTable(TableView<MonthlyExpenses> table, TableColumn<MonthlyExpenses, Integer> mortgageHouseColumn,
                                       TableColumn<MonthlyExpenses, Integer> mortgageCarColumn, TableColumn<MonthlyExpenses, Integer> creditCardDebtColumn,
                                       ObservableList<Player> players) {
        mortgageHouseColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHome_payment()).asObject());
        mortgageCarColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCar_loan()).asObject());
        creditCardDebtColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCredit_card_payment()).asObject());

        ObservableList<MonthlyExpenses> observableData = FXCollections.observableArrayList();

            MonthlyExpenses monthlyExpenses = players.get(GameEngine.PlayerTurn).getMesicne();
            observableData.add(monthlyExpenses);
            table.setItems(observableData);
    }

    public static void setDebtTable(TableView<Debts> table, TableColumn<Debts, Integer> mortgageHouseColumn,
                                    TableColumn<Debts, Integer> mortgageCarColumn, TableColumn<Debts, Integer> creditCardDebtColumn,
                                    ObservableList<Player> players) {
        mortgageHouseColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHome_debt()).asObject());
        mortgageCarColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCar_debt()).asObject());
        creditCardDebtColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCredit_card_debt()).asObject());

        ObservableList<Debts> observableDataDebt = FXCollections.observableArrayList();
        Debts debt = players.get(GameEngine.PlayerTurn).getDluhy();
        observableDataDebt.add(debt);

        table.setItems(observableDataDebt);
    }

    public static void setInfoTable(TableView<Player> table, TableColumn<Player, String> nameColumn,
                                    TableColumn<Player, String> surnameColumn, TableColumn<Player, String> professionColumn,
                                    ObservableList<Player> players) {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJmeno()));
        surnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrijmeni()));
        professionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfese()));

        ObservableList<Player> playerInfoData = FXCollections.observableArrayList();
        Player pl = new Player(players.get(GameEngine.PlayerTurn).getJmeno(), players.get(GameEngine.PlayerTurn).getPrijmeni(), players.get(GameEngine.PlayerTurn).getProfese());
        playerInfoData.add(pl);

        table.setItems(playerInfoData);


    }
    public static void setSalary(Label salarydescription, ObservableList<Player> players){

        salarydescription.setText(String.valueOf(players.get(GameEngine.PlayerTurn).getPlat()));
    }
    public static void setCurrentMoney(Label currentMoney, ObservableList<Player> players){

        currentMoney.setText(String.valueOf(players.get(GameEngine.PlayerTurn).getCurrentMoney()));
    }
    public static void setCurrentExpenses(Label currentExpenses, ObservableList<Player> players){

        currentExpenses.setText(String.valueOf(players.get(GameEngine.PlayerTurn).getCurrentExpenses()));
    }
    public static void setInvestmentsTable(TableView<Investments> table, TableColumn<Investments, Integer> investAmount,
                                           TableColumn<Investments, String> investTicker, TableColumn<Investments, Integer> investPrice,
                                           TableColumn<Investments, Integer> investDividend, ObservableList<Investments> investmentsList) {
        investAmount.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAmount()).asObject());
        investTicker.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTicker()));
        investPrice.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice()).asObject());
        investDividend.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDividend()).asObject());

        table.setItems(investmentsList);
    }
}
