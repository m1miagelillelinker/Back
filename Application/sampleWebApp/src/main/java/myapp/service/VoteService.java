package myapp.service;

import java.util.List;

import myapp.model.Vote;

public interface VoteService {
	
	Vote upsertVote(Vote vote);
	
	void deleteVote(Vote vote);
	
	List<Vote> getVotesByUser(String userId);
	
	List<Vote> getVotesByAssociation(String associationId);
}
