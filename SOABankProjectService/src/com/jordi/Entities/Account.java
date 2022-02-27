package com.jordi.Entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="Account")
public class Account implements Serializable {
    private long code;
    private double balance;
    private String creation_date;
    public  static PreparedStatement state

    public Account() {
        super();
    }

    public Account(long code, double balance, String creation_date) {
        this.code = code;
        this.balance = balance;
        this.creation_date = creation_date;
    }

    public static Account store(long code, double balance, String creation_date) throws SQLException {
        Account account = new Account(code, balance, creation_date);
        String query = "INSERT INTO accounts (code, balance,creation_date) VALUE(?,?,?)";
        state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
        state.setLong(1, code);
        state.setDouble(2, balance);
        state.setString(3, creation_date);
        System.out.println(state);
        int rs = state.executeUpdate();
        return account;
    }

    public static List<Account> AccountList() {
        List<Account> AccList = new ArrayList<Account>();

        String query = "SELECT * FROM accounts";
        try {
            state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
            System.out.println(state);
            ResultSet resultat = state.executeQuery();

            while (resultat.next()) {
                AccList.add(new Account(resultat.getInt("code"), resultat.getDouble("balance"), resultat.getString("creation_date")));
            }
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AccList;
    }

    public static Account getAccount(long code) {
        Account account = new Account();
        String query = "SELECT * FROM accounts where code="+code;
        try {
            state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
            System.out.println(state);
            ResultSet resultat = state.executeQuery();

            while (resultat.next()) {
                account = new Account(resultat.getInt("code"), resultat.getDouble("balance"), resultat.getString("creation_date"));
            }
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public static void deposit(long code, double amount){
       try {
           String query = "UPDATE accounts set balance = balance + ? WHERE code = ?";
           state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
           state.setDouble(1, amount);
           state.setLong(2, code);
           System.out.println(state);
           int rs = state.executeUpdate();
       } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public static void withdraw(long code, double amount){
        try {

        String query = "UPDATE accounts set balance = balance - ? WHERE code = ?";
        state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
        state.setDouble(1, amount);
        state.setLong(2, code);
        System.out.println(state);
        int rs = state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void transafert(long src_code, long dest_code, double amount){
        //Whithdraw
        try {

        String query = "UPDATE accounts set balance = balance - ? WHERE code = ?";
        state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
        state.setDouble(1, amount);
        state.setLong(2, src_code);
        System.out.println(state);
        int rs = state.executeUpdate();

        //Deposit
        query = "UPDATE accounts set balance = balance + ? WHERE code = ?";
        state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
        state.setDouble(1, amount);
        state.setLong(2, dest_code);
        System.out.println(state);
        rs = state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(long code){
        try {
            String query = "DELETE FROM accounts WHERE code = ?";
            state = (PreparedStatement) ConnexionBD.getInstance().prepareStatement(query);
            state.setLong(1, code);
            System.out.println(state);
            int rs = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
}
