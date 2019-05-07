package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.Vote;

public interface VoteService {
	
	Vote upsertVote(Vote vote);
	
	void deleteVote(Vote vote);
	
	List<Vote> getVotesByUser(int userId);
	
	List<Vote> getVotesByAssociation(int associationId);
	
	Vote getVoteByUserOnAsso(int userId, int associationId);
}
