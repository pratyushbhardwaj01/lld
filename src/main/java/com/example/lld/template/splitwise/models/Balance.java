package com.example.lld.template.splitwise.models;

import java.math.BigDecimal;

public class Balance {
    private User user;
    private BigDecimal amount;

    public Balance(User user, BigDecimal amount) {
        this.amount = amount;
        this.user = user;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public User getUser() {
        return this.user;
    }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
