package com.example.lld.template.splitwise.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BalanceSheet {
    private final User owner;
    private final Map<User, Double> balances = new ConcurrentHashMap<>();

    public BalanceSheet(User owner) {
        this.owner = owner;
    }

    public Map<User, Double> getBalances() {
        return this.balances;
    }

    public void updateBalance(User otherUser, double amount) {
        if (owner.equals(otherUser)) {
            return;
        }
        this.balances.merge(otherUser, amount, Double::sum);
    }

    public void showBalances() {
        System.out.println("BalanceSheet for the User: " + this.owner.getName() + " ---------");
        if (balances.isEmpty()) {
            System.out.println("The User is already settled..");
            return;
        }
        double totalOweToMe = 0;
        double totalIOwe = 0;
        for (Map.Entry<User, Double> balance : this.balances.entrySet()) {
            User otherUser = balance.getKey();
            double amount = balance.getValue();
            if (amount < 0.01) {
                System.out.println(this.owner.getName() + " owes " + otherUser.getName() + " $ " + String.format("%.2f", amount));
                totalIOwe += (-amount);
            }
            if (amount > 0.01) {
                System.out.println(otherUser.getName() + " Owes " + this.owner.getName() + " $ " + String.format("%.2f", amount));
                totalOweToMe += amount;
            }

        }
        System.out.println("Total Owed to " + owner.getName() + ": $" + String.format("%.2f", totalOweToMe));
        System.out.println("Total " + owner.getName() + " Owes: $" + String.format("%.2f", totalIOwe));
        System.out.println("---------------------------------");
    }
}
