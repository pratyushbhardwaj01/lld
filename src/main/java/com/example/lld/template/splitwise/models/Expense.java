package com.example.lld.template.splitwise.models;

import com.example.lld.template.splitwise.definations.SplitStrategy;

import java.time.Instant;
import java.util.List;

public class Expense {
    private final double amount;
    private final String description;
    private final User paidBy;
    private final List<Split> splits;
    private final Instant createdAt;
    private final Group group;

    private Expense(Builder builder) {
        this.amount = builder.amount;
        this.description = builder.description;
        this.paidBy = builder.paidBy;
        this.splits = builder.splitStrategy.createSplits(builder.amount, builder.participationAmounts, builder.participants);
        this.createdAt = builder.createdAt;
        this.group = builder.group;
    }

    public static class Builder {
        private double amount;
        private String description;
        private User paidBy;
        private Instant createdAt;
        private Group group;
        private SplitStrategy splitStrategy;
        private List<Double> participationAmounts;
        private List<User> participants;

       public Builder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

       public Builder setStrategy(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
            return this;
        }

        public Builder setParticipationAmounts(List<Double> participationAmounts) {
            this.participationAmounts = participationAmounts;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDescription(String desc) {
            this.description = desc;
            return this;
        }

        public Builder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public Builder setCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setGroup(Group group) {
            this.group = group;
            return this;
        }

        public Expense createExpense() {
            return new Expense(this);
        }
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }
    public String getDescription() {
        return this.description;
    }
}
