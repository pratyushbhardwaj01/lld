package com.example.lld.template.splitwise.models;

import com.example.lld.template.splitwise.definations.SplitFactory;
import com.example.lld.template.splitwise.enums.SplitTypes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String expenseId;
    private final Instant createdAt;
    private final String groupId;
    private final User paidBy;
    private final BigDecimal amount;
    private final List<Split> splits;

    private Expense(Builder builder) {
        this.expenseId = builder.expenseId;
        this.createdAt = builder.createdAt;
        this.groupId = builder.groupId;
        this.paidBy = builder.paidBy;
        this.amount = builder.amount;
        this.splits = new SplitFactory(builder.splitType).getSplits().createSplits(builder.amount, builder.contributors, builder.contributions);
    }


    public static class Builder {
        private String expenseId;
        private Instant createdAt;
        private String groupId;
        private SplitTypes splitType;
        private User paidBy;
        private BigDecimal amount;
        private List<User> contributors;
        private List<BigDecimal> contributions;

        public Builder() {
            this.expenseId = UUID.randomUUID().toString();
            this.createdAt = Instant.now();
            this.groupId = UUID.randomUUID().toString();
        }

        public Builder setSplitType(SplitTypes splitType) {
            this.splitType = splitType;
            return this;
        }

        public Builder setPaidBy(User user) {
            this.paidBy = user;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setContributors(List<User> userList) {
            this.contributors = userList;
            return this;
        }

        public Builder setContributions(List<BigDecimal> contributions) {
            this.contributions = contributions;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }

    public List<Split> getSplits() {
        return this.splits;
    }
    public User getPaidBy() {
        return this.paidBy;
    }


}
