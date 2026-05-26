package com.example.lld.template.splitwise;

import com.example.lld.template.splitwise.enums.SplitTypes;
import com.example.lld.template.splitwise.models.Expense;
import com.example.lld.template.splitwise.models.Group;
import com.example.lld.template.splitwise.models.User;
import com.example.lld.template.splitwise.services.Splitwise;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = Splitwise.getSplitwiseInstance();

        User user1 = splitwise.addUser("Mahendra");
        User user2 = splitwise.addUser("Pawan");
        User user3 = splitwise.addUser("Pratyush");

        Group g = splitwise.addGroup("Travel", List.of(user1, user2, user3));
        Expense.Builder builder = new Expense.Builder();
        Expense e1 = builder.setAmount(new BigDecimal(1000)).setSplitType(SplitTypes.EQUAL_AMOUNT).setPaidBy(user1).setContributors(List.of(user1, user2, user3)).build();
        splitwise.createGroupExpense(g.getGroupId(), e1);
        splitwise.seattleGroupExpense(g.getGroupId(), user2.getUserId(), user1.getUserId(), new BigDecimal("333.33"));
        splitwise.simplifyGroupExpenses(g.getGroupId());
    }

}
