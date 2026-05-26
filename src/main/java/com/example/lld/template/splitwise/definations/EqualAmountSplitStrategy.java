package com.example.lld.template.splitwise.definations;

import com.example.lld.template.splitwise.models.Split;
import com.example.lld.template.splitwise.models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EqualAmountSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> createSplits(BigDecimal amount, List<User> contributors, List<BigDecimal> splitAmounts) {
        if (splitAmounts != null && !splitAmounts.isEmpty()) {
            throw new IllegalArgumentException("Equal split does not need split amounts");
        }
        BigDecimal splitAmount = amount.divide(BigDecimal.valueOf(contributors.size()), 2, RoundingMode.HALF_UP);
        List<Split> splits = new ArrayList<>();
        for (User user : contributors) {
            Split split = new Split(user, splitAmount);
            splits.add(split);
        }
        return splits;
    }
}
