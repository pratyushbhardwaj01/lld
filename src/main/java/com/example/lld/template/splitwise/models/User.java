package com.example.lld.template.splitwise.models;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final BalanceSheet balanceSheet;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.balanceSheet = new BalanceSheet(this);

    }

    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
