package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.enumeration.VoteTypeEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.repository.VoteRepository;
import com.hicouch.back.core.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote upsertVote(Vote vote) throws NoResultException {
        if(vote.getId() != null ){
            Optional<Vote> voteOpt= voteRepository.findById(vote.getId());
            if(voteOpt.isPresent()){
                if(vote.getVote() == 0){
                    voteRepository.delete(vote);
                    return vote;
                }else{
                    Vote voteOld = voteOpt.get();
                    voteOld.setVote(vote.getVote());
                    vote = voteOld;
                }
            }else{
                throw new NoResultException();
            }
        }else{
            vote.setCreatedAt(LocalDateTime.now());
        }

        if( vote.getIdPair() != 0){
            vote.setType(VoteTypeEnum.ASSOCIATION);
        }else{
            vote.setType(VoteTypeEnum.COMMENTAIRE);
        }
        vote.setUpdatedAt(LocalDateTime.now());
        voteRepository.save(vote);
        return vote;
    }

	@Override
	public void deleteVote(Vote vote) {
		voteRepository.delete(vote);
	}

	@Override
	public List<Vote> getVotesByUser(int userId) {
		return voteRepository.findAllByIdUserAndIdCommentaireNotNull(userId);
	}

	@Override
	public List<Vote> getVotesByAssociation(int pairId) {
		return voteRepository.findAllByIdPair(pairId);
	}

	@Override
	public Vote getVoteByUserOnAsso(int userId, int pairId) throws NoResultException {
		return voteRepository.findOneByIdUserAndIdPair(userId, pairId).orElseThrow(NoResultException::new);
	}

    @Override
    public List<Vote> getVotesByCommentId(int commentId) {
        return voteRepository.findAllByIdCommentaire(commentId);
    }
}
