package com.assignment.demo.common;

import com.assignment.demo.model.Account;
import com.assignment.demo.model.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final Logger logger = LogManager.getLogger(DataGenerator.class);

    private static final Random random = new Random();
    private static final String[] NAMES = {"John", "Alice", "Bob", "Emma", "Michael", "Sophia"};
    private static final String[] SURNAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis"};

    public static void main(String[] args) {
        String randomName = generateRandomName();
        String randomSurname = generateRandomSurname();
        List<Account> randomAccounts = generateRandomAccounts(3);
        List<Transaction> randomTransactions = generateRandomTransactions(3);

        // Example usage:
        logger.info("Random Name: " + randomName);
        logger.info("Random Surname: " + randomSurname);
        logger.info("Random Accounts: " + randomAccounts);
        logger.info("Random Transactions: " + randomTransactions);
    }

    public static String generateRandomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    public static String generateRandomSurname() {
        return SURNAMES[random.nextInt(SURNAMES.length)];
    }

    public static List<Account> generateRandomAccounts(int count) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Account account = new Account();
            // Set other account properties as needed
            accounts.add(account);
        }
        return accounts;
    }

    public static List<Transaction> generateRandomTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Transaction transaction = new Transaction(random.nextDouble() * 100, "Transaction " + (i + 1));
            transactions.add(transaction);
        }
        return transactions;
    }

}