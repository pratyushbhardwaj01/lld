package com.example.lld.template.ElectionSystem;

import com.example.lld.template.ElectionSystem.definitions.OnePersonOneVoteStrategy;
import com.example.lld.template.ElectionSystem.enums.ElectionStatus;
import com.example.lld.template.ElectionSystem.enums.Symbol;
import com.example.lld.template.ElectionSystem.models.Candidate;
import com.example.lld.template.ElectionSystem.models.Election;
import com.example.lld.template.ElectionSystem.models.Voter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Voter v1 = createVoter("Pratyush Bhardwaj", "101");
        Voter v2 = createVoter("Suraj", "102");
        Voter v3 = createVoter("Ram", "103");
        Voter v4 = createVoter("Mohan", "104");
        Voter v5 = createVoter("Sohan", "105");
        Candidate c1 = createCandidate("Rahul", "106", Symbol.HAND);
        Candidate c2 = createCandidate("Modi", "107", Symbol.LOTUS);
        Candidate c3 = createCandidate("Modi", "107", Symbol.CYCLE);
        Election e1 = new Election("e101", List.of(v1, v2, v3, v4, v5), List.of(c1, c2, c3), new OnePersonOneVoteStrategy());
        ElectionSystem electionSystem = new ElectionSystem();
        electionSystem.createElection(e1);
        e1.castVote(v1, c1);
        e1.castVote(v2, c1);
        e1.castVote(v3, c1);
        e1.castVote(v4, c2);
        e1.castVote(v5, c2);
        e1.castVote(v5, c2);
        e1.setElectionStatus(ElectionStatus.COMPLETED);
        e1.castVote(v5, c2);
        e1.printElectionResult();
    }

    public static Voter createVoter(String name, String id) {
        return new Voter(name, id, 1);
    }

    public static Candidate createCandidate(String name, String id, Symbol symbol) {
        return new Candidate(id, name, symbol);
    }
}
