package com.example.lld.template.splitwise.models;

public class Transaction {
    private User from;
    private User to;
    private double amount;

    public Transaction(User from, User to, double amount) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return this.from.getName() + " should pay " + this.amount + " to " + this.to.getName();

    }
}
