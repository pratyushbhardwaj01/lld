package com.example.lld.template.splitwise.models;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private User owner;
    private ConcurrentHashMap<String, ConcurrentHashMap<User, BigDecimal>> groupBalances;
    private ConcurrentHashMap<User, BigDecimal> nonGroupBalances;

    public BalanceSheet(User user) {
        this.owner = user;
        this.groupBalances = new ConcurrentHashMap<>();
        this.nonGroupBalances = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, ConcurrentHashMap<User, BigDecimal>> getGroupBalances() {
        return this.groupBalances;
    }

    public Map<User, BigDecimal> getNonGroupBalances() {
        return this.nonGroupBalances;
    }

    public void settleNonGroupBalance(User user, BigDecimal amount) {
        if (Objects.equals(user, owner)) {
            return;
        }
        this.nonGroupBalances.merge(user, amount, BigDecimal::add);
    }

    public void settleGroupExpense(String groupId, User user, BigDecimal amount) {
        this.groupBalances.computeIfAbsent(groupId, k -> new ConcurrentHashMap<>()).merge(user, amount, BigDecimal::add);
    }

    public void printBalance() {
        System.out.println("Printing the balance for the user: " + owner.getUserName());
        BigDecimal totalYouOwe = new BigDecimal(0);
        BigDecimal totalOthersOweYou = new BigDecimal(0);
        for (BigDecimal value : this.nonGroupBalances.values()) {
            if (value.compareTo(BigDecimal.ZERO) > 0) {
                totalOthersOweYou = totalOthersOweYou.add(value);
            } else {
                totalYouOwe = totalYouOwe.add(value.abs());
            }
        }
        for (Map<User, BigDecimal> entry : this.groupBalances.values()) {
            for (BigDecimal amount : entry.values()) {
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    totalYouOwe = totalYouOwe.add(amount);
                } else {
                    totalOthersOweYou = totalOthersOweYou.add(amount.abs());
                }
            }
        }
        System.out.println("Total amount you owe $: " + totalYouOwe + " and total amount others owe you $ " + totalOthersOweYou);
    }
}
