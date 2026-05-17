package com.example.lld.template.splitwise.definations;

import com.example.lld.template.splitwise.models.Split;
import com.example.lld.template.splitwise.models.User;

import java.util.ArrayList;
import java.util.List;

public class ExactAmountSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> createSplits(double amount, List<Double> participationAmounts, List<User> participants) {
        if (participants.size() != participationAmounts.size()) {
            throw new IllegalArgumentException("Number of participants and amounts does not match");
        }
        double totalAmount = 0.0;
        for (double participationAmount : participationAmounts) {
            totalAmount += participationAmount;
        }
        if (Math.abs(participationAmounts.stream().mapToDouble(Double::doubleValue).sum() - totalAmount) > 0.01) {
            throw new IllegalArgumentException("Sum of exact amounts must equal the total expense amount.");
        }
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < participationAmounts.size(); i++) {
            double participationAmount = participationAmounts.get(i);
            User user = participants.get(i);

            Split s = new Split(participationAmount, user);
            splits.add(s);
        }
        return splits;
    }
}
