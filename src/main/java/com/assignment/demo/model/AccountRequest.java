package com.assignment.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountRequest {
    @NotBlank
    private String customerId;
    @NotNull
    private double initialCredit;

    public AccountRequest(String customerId, double initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }

    // getters and setters
}