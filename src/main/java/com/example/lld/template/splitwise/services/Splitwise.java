package com.example.lld.template.splitwise.services;

import com.example.lld.template.splitwise.models.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Splitwise {
    private static Splitwise splitwiseInstance;
    private final ConcurrentHashMap<String, User> usersMap;
    private final ConcurrentHashMap<String, Group> groupsMap;

    private Splitwise() {
        this.usersMap = new ConcurrentHashMap<>();
        this.groupsMap = new ConcurrentHashMap<>();
    }

    public synchronized static Splitwise getSplitwiseInstance() {
        if (splitwiseInstance == null) {
            return splitwiseInstance = new Splitwise();
        }
        return splitwiseInstance;
    }

    public User addUser(String name) {
        User user = new User(name);
        this.usersMap.put(user.getUserId(), user);
        return user;

    }

    public Group addGroup(String name, List<User> members) {
        Group group = new Group(name, members);
        this.groupsMap.put(group.getGroupId(), group);
        return group;
    }

    public void createGroupExpense(String groupId, Expense expense) {
        Group group = groupsMap.get(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group id does not exist in the system" + groupId);
        }
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }
        for (Split split : expense.getSplits()) {
            User user = split.getUser();
            BigDecimal amount = split.getAmount();
            if (!Objects.equals(user, expense.getPaidBy())) {
                user.getBalanceSheet().settleGroupExpense(groupId,expense.getPaidBy(), amount.negate());
                expense.getPaidBy().getBalanceSheet().settleGroupExpense(groupId, user, amount);
            }
        }
    }

    public void settleIndividualExpense(String payerId, String payeeId, BigDecimal amount) {
        User payer = usersMap.get(payerId);
        User payee = usersMap.get(payeeId);
        if (payer == null || payee == null) {
            throw new IllegalArgumentException("User id not found in the system ");
        }
        payer.getBalanceSheet().settleNonGroupBalance(payee, amount);
        payee.getBalanceSheet().settleNonGroupBalance(payer, amount.negate());
    }

    public void seattleGroupExpense(String groupId, String payerId, String payeeId, BigDecimal amount) {
        User payer = usersMap.get(payerId);
        User payee = usersMap.get(payeeId);
        if (payee == null || payer == null) {
            throw new IllegalArgumentException("Used id not found in the system");
        }
        payer.getBalanceSheet().settleGroupExpense(groupId, payee, amount);
        payee.getBalanceSheet().settleGroupExpense(groupId, payer, amount.negate());
    }

    public void simplifyGroupExpenses(String groupId) {
        Group group = groupsMap.get(groupId);
        if (group == null) {
            throw new IllegalArgumentException("The group id does not exist in the system " + groupId);
        }
        List<Balance> creditors = new ArrayList<>();
        List<Balance> debitors = new ArrayList<>();
        Map<User, BigDecimal> netBalance = new HashMap<>();
        for (User user : group.getMembers()) {
            for (Map.Entry<User, BigDecimal> entry : user.getBalanceSheet().getGroupBalances().get(groupId).entrySet()) {
                netBalance.merge(user, entry.getValue(), BigDecimal::add);
            }
        }
        for (Map.Entry<User, BigDecimal> entry : netBalance.entrySet()) {
            if (entry.getValue().compareTo(BigDecimal.ZERO) > 0) {
                creditors.add(new Balance(entry.getKey(), entry.getValue()));
            }
            if (entry.getValue().compareTo(BigDecimal.ZERO) < 0) {
                debitors.add(new Balance(entry.getKey(), entry.getValue().abs()));
            }
        }
        creditors.sort((a, b) -> b.getAmount().compareTo(a.getAmount()));
        debitors.sort((a, b) -> b.getAmount().compareTo(a.getAmount()));
        int i = 0;
        int j = 0;
        while (i < creditors.size() && j < debitors.size()) {
            Balance creditor = creditors.get(i);
            Balance debitor = debitors.get(j);
            BigDecimal settlement = creditor.getAmount().min(debitor.getAmount());
            System.out.println(debitor.getUser().getUserName() + " has to pay " + creditor.getUser().getUserName() + " $ " + settlement);
            creditor.setAmount(creditor.getAmount().subtract(settlement));
            debitor.setAmount(debitor.getAmount().subtract(settlement));
            if (creditor.getAmount().compareTo(BigDecimal.ZERO) == 0) {
                i++;
            }
            if (debitor.getAmount().compareTo(BigDecimal.ZERO) == 0) {
                j++;
            }
        }
    }
}
