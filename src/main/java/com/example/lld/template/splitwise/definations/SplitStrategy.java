package com.example.lld.template.splitwise.definations;

import com.example.lld.template.splitwise.models.Split;
import com.example.lld.template.splitwise.models.User;

import java.math.BigDecimal;
import java.util.List;

public interface SplitStrategy {
    public List<Split>  createSplits(BigDecimal amount,List<User>contributors, List<BigDecimal>splitAmounts);
}
