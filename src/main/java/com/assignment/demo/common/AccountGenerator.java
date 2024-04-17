package com.assignment.demo.common;

import com.assignment.demo.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountGenerator {

    public List<Account> generateRandomAccounts(int count) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Account account = new Account();
            // You can set other account properties as needed
            accounts.add(account);
        }
        return accounts;
    }
}
