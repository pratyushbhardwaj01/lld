package com.example.lld.template.ElectionSystem.models;

import com.example.lld.template.ElectionSystem.definitions.BaseVotingStrategy;
import com.example.lld.template.ElectionSystem.enums.ElectionStatus;

import java.util.*;
import java.util.stream.Collectors;

public class Election {
    private String id;
    private List<Voter> voterList;
    private List<Candidate> candidates;
    private ElectionStatus electionStatus;
    private VotingRecord votingRecord;
    private BaseVotingStrategy strategy;

    public Election(String id, List<Voter> voterList, List<Candidate> candidates, BaseVotingStrategy strategy) {
        this.id = id;
        this.voterList = voterList;
        this.candidates = candidates;
        this.votingRecord = new VotingRecord(candidates);
        this.strategy = strategy;
        this.electionStatus = ElectionStatus.IN_PROGRESS;
    }


    public String getElectionId() {
        return this.id;
    }

    public List<Voter> getVoterList() {
        return this.voterList;
    }

    public List<Candidate> getCandidates() {
        return this.candidates;
    }

    public ElectionStatus getElectionStatus() {
        return this.electionStatus;
    }

    public VotingRecord getVotingRecord() {
        return this.votingRecord;
    }

    public synchronized void castVote(Voter voter, Candidate candidate) {
        if (electionStatus != ElectionStatus.IN_PROGRESS) {
            System.out.println("Cannot cast vote in electionId: " + this.id + "as voting status is " + this.electionStatus);
            return;
        }
        boolean canCastVote = strategy.canVoterCastVote(voter, candidate, this);
        if (canCastVote) {
            this.strategy.castVote(voter, candidate, votingRecord);
            System.out.println("The voterId " + voter.getId() + " has casted vote");
        }
    }

    public void setElectionStatus(ElectionStatus electionStatus) {
        this.electionStatus = electionStatus;
    }

    public void printElectionResult() {
        Map<Candidate, Integer> sortedMap = this.votingRecord.getCandidateToVoteMap().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        for (Map.Entry<Candidate, Integer> x : sortedMap.entrySet()) {
            System.out.println(x.getKey().getCandidateSymbol() + " " + x.getValue());
        }
    }


}
