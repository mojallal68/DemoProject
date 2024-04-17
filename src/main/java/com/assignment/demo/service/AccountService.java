package com.assignment.demo.service;

import com.assignment.demo.model.*;
import com.assignment.demo.common.AccountGenerator;
import com.assignment.demo.common.DataGenerator;
import com.assignment.demo.common.TransactionGenerator;
import com.assignment.demo.exceptions.CustomerNotFoundException;
import com.assignment.demo.exceptions.InvalidRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final AccountGenerator accountGenerator;
    private final TransactionGenerator transactionGenerator;
     Map<String, Customer> customers = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    @Autowired
    public AccountService(AccountGenerator accountGenerator, TransactionGenerator transactionGenerator) {
        this.accountGenerator = accountGenerator;
        this.transactionGenerator = transactionGenerator;
    }

    public ResponseEntity<String> openAccount(AccountRequest request) {
        String customerId = request.getCustomerId();
        double initialCredit = request.getInitialCredit();

        if (customerId.isEmpty() || initialCredit < 0) {
            logger.error("Invalid request: customerId={}, initialCredit={}", customerId, initialCredit);
            throw new InvalidRequestException("Invalid customer ID or initial credit");
        }

        if (!customers.containsKey(customerId)) {
            Customer customer = new Customer(customerId, DataGenerator.generateRandomName(), DataGenerator.generateRandomSurname(),
                    accountGenerator.generateRandomAccounts(3), transactionGenerator.generateRandomTransactions(3));
            customers.put(customerId, customer);
        } else {
            logger.warn("CustomerId {}  is already activated in system", customerId);
            return ResponseEntity.ok("CustomerId " + customerId + " already activated in system. You can not double active same customerId");

        }


        Account account = new Account();
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        Customer customer = customers.get(customerId);
        customer.setAccounts(accountList);

        if (initialCredit != 0) {
            Transaction transaction = new Transaction(initialCredit, "Initial credit");
            List<Transaction> transactionList = new ArrayList<>();
            transactionList.add(transaction);
            account.setTransactions(transactionList);

        }

        logger.info("Account opened successfully for customer: " + customerId);
        return ResponseEntity.ok("Account opened successfully for customer: " + customerId);
    }

    public ResponseEntity<CustomerInfo> getCustomerInfo(String customerId) {
        if (customers.containsKey(customerId)) {
            Customer customer = customers.get(customerId);
            return ResponseEntity.ok(new CustomerInfo(customer.getName(), customer.getSurname(), customer.calculateBalance(), customer.getTransactions()));
        }
        logger.warn("Customer not found with ID: " + customerId);
        throw new CustomerNotFoundException("Customer not found with ID: " + customerId);

    }
}
