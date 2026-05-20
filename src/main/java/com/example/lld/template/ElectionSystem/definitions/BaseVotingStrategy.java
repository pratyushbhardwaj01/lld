package com.example.lld.template.ElectionSystem.definitions;

import com.example.lld.template.ElectionSystem.models.Candidate;
import com.example.lld.template.ElectionSystem.models.Election;
import com.example.lld.template.ElectionSystem.models.Voter;
import com.example.lld.template.ElectionSystem.models.VotingRecord;

public interface BaseVotingStrategy {
    public void castVote(Voter voter, Candidate candidate, VotingRecord votingRecord);
    public Boolean canVoterCastVote(Voter voter, Candidate candidate, Election election);
}
