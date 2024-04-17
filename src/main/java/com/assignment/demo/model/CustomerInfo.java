package com.assignment.demo.model;

import java.util.List;

public class CustomerInfo {
    private String name;
    private String surname;
    private double balance;
    private List<Transaction> transactions;

    public CustomerInfo(String name, String surname, double balance, List<Transaction> transactions) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}