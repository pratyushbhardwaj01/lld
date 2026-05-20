package com.example.lld.template.ElectionSystem.definitions;

import com.example.lld.template.ElectionSystem.models.Candidate;

import com.example.lld.template.ElectionSystem.models.Election;
import com.example.lld.template.ElectionSystem.models.Voter;
import com.example.lld.template.ElectionSystem.models.VotingRecord;

import java.util.List;
import java.util.Objects;


public class OnePersonOneVoteStrategy implements BaseVotingStrategy {
    @Override
    public void castVote(Voter voter, Candidate candidate, VotingRecord votingRecord) {
        votingRecord.addVote(voter, candidate, 1);
    }

    @Override
    public Boolean canVoterCastVote(Voter voter, Candidate candidate, Election election) {
        List<Candidate> candidateList = election.getCandidates();
        List<Voter> voters = election.getVoterList();
        if (!isVoterPresentInVoterList(voters, voter)) {
            System.out.println("The voter is not present in voter list so can't cast the vote");
            return false;
        }
        if (!isAValidCandidate(candidateList, candidate)) {
            System.out.println("The candidate is not present in the candidate list so can't vote for that candidate");
            return false;
        }
        if (isVoterAlreadyCastedVote(voter, election)) {
            return false;
        }
        return true;
    }

    private Boolean isVoterPresentInVoterList(List<Voter> voters, Voter voter) {
        for (Voter v : voters) {
            if (Objects.equals(v.getId(), voter.getId())) {
                System.out.println("The voter has already casted the vote");
                return true;
            }
        }
        return false;
    }

    private Boolean isAValidCandidate(List<Candidate> candidates, Candidate candidate) {
        for (Candidate c : candidates) {
            if (Objects.equals(c.getId(), candidate.getId())) {
                return true;
            }
        }
        return false;
    }

    private Boolean isVoterAlreadyCastedVote(Voter voter, Election election) {
        VotingRecord votingRecord = election.getVotingRecord();
        for (Voter v : votingRecord.getVotersList()) {
            if (Objects.equals(v.getId(), voter.getId())) {
                return true;
            }
        }
        return false;
    }
}
