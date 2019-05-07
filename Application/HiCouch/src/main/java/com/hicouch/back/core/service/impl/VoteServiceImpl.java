package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.VoteRepository;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.VoteService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
	
	@Override
	public Vote upsertVote(Vote vote) {
		if(vote.getId() != null) {
			Optional<Vote> voteOpt = voteRepository.findById(vote.getId());
			if(voteOpt.isPresent()) {
				Vote voteOld = voteOpt.get();
				voteOld.setVote(vote.getVote());
				vote = voteOld;
			}
		} else {
			vote.setCreatedAt(new Date());
		}
		
		if(vote.getVote() == 0) {
			voteRepository.delete(vote);
			vote = null;
		} else {
			vote.setUpdatedAt(new Date());
			voteRepository.save(vote);
		}
		
		return vote;
	}

	@Override
	public void deleteVote(Vote vote) {
		voteRepository.delete(vote);
	}

	@Override
	public List<Vote> getVotesByUser(int userId) {
		return voteRepository.findAllByIdUser(userId).get();
	}

	@Override
	public List<Vote> getVotesByAssociation(int pairId) {
		return voteRepository.findAllByIdPair(pairId).get();
	}

	@Override
	public Vote getVoteByUserOnAsso(int userId, int pairId) {
		Optional<Vote> vote = voteRepository.findOneByIdUserAndIdPair(userId, pairId);
		return vote.isPresent() ? vote.get() : null; 
	}
}
