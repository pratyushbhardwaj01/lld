package com.example.lld.template.splitwise.services;

import com.example.lld.template.splitwise.models.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SplitwiseService {
    private final Map<String, User> usersMap = new ConcurrentHashMap<>();
    private final Map<String, Group> groupMap = new ConcurrentHashMap<>();
    private static SplitwiseService splitwiseInstance;

    public static synchronized SplitwiseService getInstance() {
        if (splitwiseInstance == null) {
            return new SplitwiseService();
        }
        return splitwiseInstance;
    }

    public User addUser(String name) {
        User user = new User(name);
        this.usersMap.put(user.getId(), user);
        return user;
    }

    public Group addGroup(String name, List<User> members) {
        Group group = new Group(name, members);
        this.groupMap.put(group.getGroupId(), group);
        return group;
    }

    public synchronized void createExpense(Expense.Builder builder) {
        Expense expense = builder.createExpense();
        User paidBy = expense.getPaidBy();
        List<Split> splits = expense.getSplits();
        for (Split split : splits) {
            User participantUser = split.getUser();
            double contribution = split.getAmount();
            if (!paidBy.equals(participantUser)) {
                participantUser.getBalanceSheet().updateBalance(paidBy, -contribution);
                paidBy.getBalanceSheet().updateBalance(participantUser, contribution);
            }
        }
        System.out.println("Expense '" + expense.getDescription() + "' of amount " + expense.getAmount() + " created.");
    }

    public synchronized void settleExpense(String payerId, String payeeId, double amount) {
        User payer = usersMap.get(payerId);
        User payee = usersMap.get(payeeId);
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());
        payer.getBalanceSheet().updateBalance(payee, amount);
        payee.getBalanceSheet().updateBalance(payer, -amount);
    }

    public synchronized List<Transaction> simplifyGroupTransactions(String groupId) {
        Group group = groupMap.get(groupId);
        List<User>members = group.getMembers();
        Map<User, Double>netBalances = new HashMap<>();
        for(User member : members) {
            double balance = 0;
            for(Map.Entry<User, Double>entry : member.getBalanceSheet().getBalances().entrySet()) {
                if(members.contains(entry.getKey())) {
                    balance += entry.getValue();
                }
            }
            netBalances.put(member, balance);
        }
        for(Map.Entry<User, Double>entry : netBalances.entrySet()) {
            System.out.println(entry.getKey().getName());
        }
//        System.out.println(netBalances);
        List<Map.Entry<User, Double>> creditors = new ArrayList<>(netBalances.entrySet().stream().filter(e -> e.getValue() > 0).toList());
        List<Map.Entry<User, Double>> debitors = new ArrayList<>(netBalances.entrySet().stream().filter(e -> e.getValue() < 0).toList());
        creditors.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        debitors.sort(Map.Entry.comparingByValue());
        List<Transaction>transactions = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < creditors.size() && j < debitors.size()) {
            Map.Entry<User, Double> creditor = creditors.get(i);
            Map.Entry<User, Double> debitor = debitors.get(j);
            double amountToSettle = Math.min(creditor.getValue(), -debitor.getValue());
            transactions.add(new Transaction(debitor.getKey(), creditor.getKey(), amountToSettle));
            creditor.setValue(creditor.getValue() - amountToSettle);
            debitor.setValue(debitor.getValue() + amountToSettle);
            if (Math.abs(creditor.getValue()) < 0.01) i++;
            if (Math.abs(debitor.getValue()) < 0.01) j++;
        }
        return transactions;
    }

}
