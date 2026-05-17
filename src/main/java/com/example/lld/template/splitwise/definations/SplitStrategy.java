package com.example.lld.template.splitwise.definations;

import com.example.lld.template.splitwise.models.Split;
import com.example.lld.template.splitwise.models.User;

import java.util.List;

public interface SplitStrategy {
    List<Split> createSplits(double amount, List<Double> participationAmounts, List<User> participants);
}
