package myapp.service.impl;

import myapp.model.Vote;
import myapp.repository.VoteRepository;
import myapp.service.VoteService;

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
		Optional<Vote> voteOpt = voteRepository.findById(vote.getId());
		if(voteOpt.isPresent()) {
			Vote voteOld = voteOpt.get();
			voteOld.setVote(vote.getVote());
			voteOld.setUpdatedAt(new Date());
			vote = voteOld;
		}
		
		if(vote.getVote() == 0) {
			voteRepository.delete(vote);
			vote = null;
		} else {
			voteRepository.save(vote);
		}
		
		return vote;
	}

	@Override
	public void deleteVote(Vote vote) {
		voteRepository.delete(vote);
	}

	@Override
	public List<Vote> getVotesByUser(String userId) {
		return voteRepository.findAllByIdUser(userId).get();
	}

	@Override
	public List<Vote> getVotesByAssociation(String associationId) {
		return voteRepository.findAllByIdAssoc(associationId).get();
	}
}
