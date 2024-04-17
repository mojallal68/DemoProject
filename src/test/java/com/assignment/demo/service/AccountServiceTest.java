package com.assignment.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.assignment.demo.model.Customer;
import com.assignment.demo.model.AccountRequest;
import com.assignment.demo.model.CustomerInfo;
import com.assignment.demo.common.AccountGenerator;
import com.assignment.demo.common.TransactionGenerator;
import com.assignment.demo.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountGenerator accountGenerator;

    @Mock
    private TransactionGenerator transactionGenerator;

    @InjectMocks
    private AccountService accountService;

    private  Map<String, Customer> customers;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field
        Field field = AccountService.class.getDeclaredField("customers");
        field.setAccessible(true);
        customers = (Map<String, Customer>) field.get(accountService);
    }


    @Test
    public void testOpenAccount() {
        // Prepare test data
        String customerId = "10";
        double initialCredit = 100.0;
        AccountRequest request = new AccountRequest(customerId, initialCredit);
        Customer customer = new Customer(customerId, "John", "Doe", new ArrayList<>(), new ArrayList<>());

        // Mock the account and transaction generators
        when(accountGenerator.generateRandomAccounts(3)).thenReturn(new ArrayList<>());
        when(transactionGenerator.generateRandomTransactions(3)).thenReturn(new ArrayList<>());

        // Call the service method
        ResponseEntity<String> response = accountService.openAccount(request);

        // Verify the response
        assertEquals(ResponseEntity.ok("Account opened successfully for customer: " + customerId), response);
    }

    @Test
    public void testWrongCustomerInfo() {
        // Prepare test data
        String customerId = "10";
        Customer customer = new Customer(customerId, "John", "Doe", new ArrayList<>(), new ArrayList<>());
        // Mock the customer map
        Map<String, Customer> customers = new HashMap<>();
        customers.put(customerId, customer);

        assertThrowsExactly(CustomerNotFoundException.class, () -> accountService.getCustomerInfo(customerId));
    }


    @Test
    public void testGetCustomerInfo() {
        // Prepare test data
        String customerId = "10";
        Customer customer = new Customer(customerId, "John", "Doe", new ArrayList<>(), new ArrayList<>());
        customers.put(customerId, customer);
        // Call the service method
        ResponseEntity<CustomerInfo> response = accountService.getCustomerInfo(customerId);
        // Verify the response
        assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
    }

}