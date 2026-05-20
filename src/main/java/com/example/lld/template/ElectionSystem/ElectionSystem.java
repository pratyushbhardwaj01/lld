package com.example.lld.template.ElectionSystem;

import com.example.lld.template.ElectionSystem.models.Election;

import java.util.HashMap;
import java.util.Map;

public class ElectionSystem {
    private Map<String, Election> electionsMap;

    public ElectionSystem() {
        this.electionsMap = new HashMap<>();
    }

    public void createElection(Election election) {
        if(electionsMap.get(election.getElectionId()) != null) {
            throw new IllegalStateException("The election already exist");
        }
        this.electionsMap.put(election.getElectionId(), election);
    }

    public Election getElectionById(String electionId) {
        return electionsMap.get(electionId);
    }
}
