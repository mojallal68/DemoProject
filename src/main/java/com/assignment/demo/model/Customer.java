package com.assignment.demo.model;

import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String surname;
    private List<Account> accounts;

    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, String name, String surname, List<Account> accounts, List<Transaction> transactions) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public double calculateBalance() {
        double balance = 0;
        for (Account account : accounts) {
            balance += account.calculateBalance();
        }
        return balance;
    }
}