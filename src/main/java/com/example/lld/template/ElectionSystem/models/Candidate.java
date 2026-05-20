package com.example.lld.template.ElectionSystem.models;

import com.example.lld.template.ElectionSystem.enums.Symbol;

public class Candidate extends Person {
    private final Symbol symbol;

    public Candidate(String id, String name, Symbol symbol) {
        super(id, name);
        this.symbol = symbol;
    }

    public Symbol getCandidateSymbol() {
        return this.symbol;
    }
}
