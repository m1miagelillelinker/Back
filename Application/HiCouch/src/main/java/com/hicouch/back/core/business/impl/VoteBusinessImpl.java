package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.VoteBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.VoteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteBusinessImpl implements VoteBusiness {

    private VoteService voteService;
    private AssociationService associationService;
    private CommentaireService commentaireService;

    @Autowired
    public VoteBusinessImpl(VoteService voteService, AssociationService associationService, CommentaireService commentaireService) {
        this.voteService = voteService;
        this.associationService = associationService;
        this.commentaireService = commentaireService;
    }

    @Override
    public Vote upsertVote(Vote vote) throws NoResultException {
        Vote oldVote = null;
        if (vote.getId() != null) {
            oldVote = voteService.getVoteById(vote.getId());
        }

        Vote v = voteService.upsertVote(vote);
        if (v.getIdPair() != null) {
            List<Association> associations = associationService.getAssociationByIdPaire(vote.getIdPair());
            for (Association association : associations) {
                association.setNote(association.getNote() + v.getVote());
                if (oldVote != null && oldVote.getVote() != null) {
                    association.setNote(association.getNote() - oldVote.getVote());
                }
                associationService.saveAssociation(association);
            }
        } else {
            Commentaire commentaire = commentaireService.findById(v.getIdCommentaire());
            commentaire.setNote(commentaire.getNote() + v.getVote());
            if (oldVote != null && oldVote.getVote() != null) {
                commentaire.setNote(commentaire.getNote() - oldVote.getVote());
            }
            commentaireService.updateCommentaire(commentaire);
        }
        return v;
    }
}
