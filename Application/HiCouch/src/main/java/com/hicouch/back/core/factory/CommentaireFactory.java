package com.hicouch.back.core.factory;

import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.UserService;
import com.hicouch.back.core.service.VoteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentaireFactory {

    private UserService userService;
    private UserFactory userFactory;
    private VoteService voteService;
    private AssociationService associationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CommentaireFactory(UserService userService, VoteService voteService, AssociationService associationService, UserFactory userFactory) {
        super();
        this.userService        = userService;
        this.userFactory        = userFactory;
        this.voteService		= voteService;
        this.associationService = associationService;
    }

    public CommentaireDTO getCommentaireDTO(Commentaire commentaire) {
        logger.trace("getCommentaireDTO");

        CommentaireDTO commentaireDTO = new CommentaireDTO();
        commentaireDTO.setAssociation(associationService.getAssociationByIdPair(commentaire.getIdPair()));
        try {
        	User u = userService.getCurrentUser();
            commentaireDTO.setAuteur(userFactory.getUserDTO(userService.getUserById(commentaire.getIdUser())));
            commentaireDTO.setOwned(u.getId() == commentaire.getIdUser());
        	Vote vote = voteService.getVoteByUserOnComment(u.getId(), commentaire.getId());
        	commentaireDTO.setVote(vote);
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        
        commentaireDTO.setCommentaire(commentaire);


        return commentaireDTO;
    }

    public List<CommentaireDTO> convertCommentaires(List<Commentaire> commentaires){
        return commentaires.stream().map(this::getCommentaireDTO).collect(Collectors.toList());
    }
}
