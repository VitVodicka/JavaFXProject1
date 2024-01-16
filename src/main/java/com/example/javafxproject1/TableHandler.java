package com.example.javafxproject1;

import com.example.javafxproject1.PlayerClasses.Debts;
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

    public static void initializeMonthlyTable(TableView<MonthlyExpenses> table, TableColumn<MonthlyExpenses, Integer> mortgageHouseColumn,
                                              TableColumn<MonthlyExpenses, Integer> mortgageCarColumn, TableColumn<MonthlyExpenses, Integer> creditCardDebtColumn,
                                              ObservableList<Player> players) {
        mortgageHouseColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHome_payment()).asObject());
        mortgageCarColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCar_loan()).asObject());
        creditCardDebtColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCredit_card_payment()).asObject());

        ObservableList<MonthlyExpenses> observableData = FXCollections.observableArrayList();
        for (Player player : players) {
            MonthlyExpenses monthlyExpenses = player.getMesicne();
            observableData.add(monthlyExpenses);
        }
        table.setItems(observableData);
    }

    public static void initializeDebtTable(TableView<Debts> table, TableColumn<Debts, Integer> mortgageHouseColumn,
                                           TableColumn<Debts, Integer> mortgageCarColumn, TableColumn<Debts, Integer> creditCardDebtColumn,
                                           ObservableList<Player> players) {
        mortgageHouseColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHome_debt()).asObject());
        mortgageCarColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCar_debt()).asObject());
        creditCardDebtColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCredit_card_debt()).asObject());

        ObservableList<Debts> observableDataDebt = FXCollections.observableArrayList();
        for (Player player : players) {
            Debts debt = player.getDluhy();
            observableDataDebt.add(debt);
        }
        table.setItems(observableDataDebt);
    }

    public static void initializeInfoTable(TableView<Player> table, TableColumn<Player, String> nameColumn,
                                           TableColumn<Player, String> surnameColumn, TableColumn<Player, String> professionColumn,
                                           ObservableList<Player> players) {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJmeno()));
        surnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrijmeni()));
        professionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfese()));

        ObservableList<Player> playerInfoData = FXCollections.observableArrayList();
        for (Player player : players) {
            Player pl = new Player(player.getJmeno(), player.getPrijmeni(), player.getProfese());
            playerInfoData.add(pl);
        }
        table.setItems(playerInfoData);


    }
    public static void initializeSalary(Label salarydescription, Player players){
        salarydescription.setText(String.valueOf(players.getPlat()));
    }
}
