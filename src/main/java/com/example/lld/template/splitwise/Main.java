package com.example.lld.template.splitwise;

import com.example.lld.template.splitwise.definations.ExactAmountSplitStrategy;
import com.example.lld.template.splitwise.models.Expense;
import com.example.lld.template.splitwise.models.Group;
import com.example.lld.template.splitwise.models.Transaction;
import com.example.lld.template.splitwise.models.User;
import com.example.lld.template.splitwise.services.SplitwiseService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SplitwiseService splitwiseInstance = SplitwiseService.getInstance();
        User u1 = splitwiseInstance.addUser("Pratyush");
        User u2 = splitwiseInstance.addUser("Mahendra");
        User u3 = splitwiseInstance.addUser("Pawan");
        List<User> members = new ArrayList<>();
        members.add(u1);
        members.add(u2);
        members.add(u3);
        Group group = splitwiseInstance.addGroup("Esha_Pg_Group", members);
        splitwiseInstance.createExpense(new Expense.Builder().setCreatedAt(Instant.now()).setAmount(1000.0).setDescription("Dinner").setGroup(group).setPaidBy(u1).setParticipants(members).setParticipationAmounts(List.of(333.0, 333.0, 333.0)).setStrategy(new ExactAmountSplitStrategy()));
        u1.getBalanceSheet().showBalances();
        List<Transaction>simplifiedDebts = splitwiseInstance.simplifyGroupTransactions(group.getGroupId());
        if (simplifiedDebts.isEmpty()) {
            System.out.println("All debts are settled within the group!");
        } else {
            simplifiedDebts.forEach(System.out::println);
        }
        System.out.println();

    }
}
