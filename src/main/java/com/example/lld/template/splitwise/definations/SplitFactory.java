package com.example.lld.template.splitwise.definations;

import com.example.lld.template.splitwise.enums.SplitTypes;


public class SplitFactory {
    private final SplitTypes splitType;

    public SplitFactory(SplitTypes splitType) {
        this.splitType = splitType;
    }

    public SplitStrategy getSplits() {
        if (splitType == SplitTypes.EQUAL_AMOUNT) {
            return new EqualAmountSplitStrategy();
        }
        return null;

    }
}
