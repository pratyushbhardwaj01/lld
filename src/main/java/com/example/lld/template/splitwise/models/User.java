package com.example.lld.template.splitwise.models;

import java.util.UUID;

public class User {
    private final String userId;
    private final String name;
    private final BalanceSheet balanceSheet;

    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.balanceSheet = new BalanceSheet(this);
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }

    public BalanceSheet getBalanceSheet() {
        return this.balanceSheet;
    }
}
