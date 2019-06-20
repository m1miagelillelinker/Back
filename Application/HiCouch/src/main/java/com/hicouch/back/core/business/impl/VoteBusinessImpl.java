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
        Vote v = voteService.upsertVote(vote);
        if(v.getIdPair() != null){
            Association association = associationService.getAssociationByIdPairr(vote.getIdPair());
            association.setNote(association.getNote()+v.getVote());
            associationService.saveAssociation(association);
        }else{
            Commentaire commentaire = commentaireService.findById(v.getIdCommentaire());
            commentaire.setNote(commentaire.getNote()+v.getVote());
            commentaireService.updateCommentaire(commentaire);
        }
        return v;
    }
}
