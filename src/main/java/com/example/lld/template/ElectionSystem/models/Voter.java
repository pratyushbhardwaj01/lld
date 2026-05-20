package com.example.lld.template.ElectionSystem.models;

public class Voter extends Person {
    private final int weightage;

    public Voter(String name, String id, int wwightage) {
        super(id, name);
        this.weightage = wwightage;
    }

    public int getVoterWeightage() {
        return this.weightage;
    }
}
