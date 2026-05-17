package com.example.lld.template.splitwise.models;

public class Split {
    private final double amount;
    private final User user;

    public Split(double amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return this.amount;
    }
}
