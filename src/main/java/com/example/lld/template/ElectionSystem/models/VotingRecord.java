package com.example.lld.template.ElectionSystem.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingRecord {
    private final List<Voter> voterList;
    private final Map<Candidate, Integer> candidateToVoteMap;

    public VotingRecord(List<Candidate> candidateList) {
        this.voterList = new ArrayList<>();
        this.candidateToVoteMap = new HashMap<>();
        for (Candidate candidate : candidateList) {
            this.candidateToVoteMap.put(candidate, 0);
        }
    }

    public void addVote(Voter voter, Candidate candidate, int weightage) {
        voterList.add(voter);
        int candidateCurrentVotes = candidateToVoteMap.getOrDefault(candidate, 0);
        candidateToVoteMap.put(candidate, candidateCurrentVotes + weightage);
    }

    public List<Voter> getVotersList() {
        return this.voterList;
    }

    public Map<Candidate, Integer> getCandidateToVoteMap() {
        return this.candidateToVoteMap;
    }

}
