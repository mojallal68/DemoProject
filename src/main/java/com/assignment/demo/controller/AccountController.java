package com.assignment.demo.controller;

import com.assignment.demo.exceptions.InvalidRequestException;
import com.assignment.demo.model.*;
import com.assignment.demo.exceptions.CustomerNotFoundException;
import com.assignment.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private Map<String, Customer> customers = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @PostMapping("/openAccount")
    public ResponseEntity<String> openAccount(@Valid @RequestBody AccountRequest request) {
        try {
            return accountService.openAccount(request);
        } catch (InvalidRequestException exception) {
            logger.warn("Invalid Request: " + exception.getMessage());
            return ResponseEntity.ok(exception.getMessage());
        }
    }

    @GetMapping("/customer/{customerId}")
    public HttpEntity<?> getCustomerInfo(@PathVariable String customerId) {
        try {
            return accountService.getCustomerInfo(customerId);
        } catch (CustomerNotFoundException exception) {
            logger.warn("CustomerNotFoundException: " + exception.getMessage());
            return ResponseEntity.ok(exception.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getMessage());
    }
}
