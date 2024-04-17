package com.assignment.demo.common;

import com.assignment.demo.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TransactionGenerator {

    private final Random random = new Random();

    public List<Transaction> generateRandomTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Transaction transaction = new Transaction(random.nextDouble() * 100, "Transaction " + (i + 1));
            transactions.add(transaction);
        }
        return transactions;
    }
}
