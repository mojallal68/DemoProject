package com.assignment.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.demo.model.AccountRequest;
import com.assignment.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void testOpenAccount() throws Exception {
        // Prepare mock data
        AccountRequest request = new AccountRequest("50", 100.0);

        // Mock the service method
        when(accountService.openAccount(request)).thenReturn(ResponseEntity.ok("Account opened successfully"));

        // Perform the POST request
        ResultActions resultActions = mockMvc.perform(post("/openAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":\"50\",\"initialCredit\":100.0}"));

        // Verify the response status
        resultActions.andExpect(status().isOk());
    }
}