package com.hicouch.back.core.factory;

import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentaireFactory {

    private UserService userService;
    private UserFactory userFactory;
    private AssociationService associationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CommentaireFactory(UserService userService, AssociationService associationService, UserFactory userFactory) {
        super();
        this.userService        = userService;
        this.userFactory        = userFactory;
        this.associationService = associationService;
    }

    public CommentaireDTO getCommentaireDTO(Commentaire commentaire) {
        logger.trace("getCommentaireDTO");

        CommentaireDTO commentaireDTO = new CommentaireDTO();

        commentaireDTO.setAssociation(associationService.getAssociationByIdPair(commentaire.getIdPair()));
        try {
            commentaireDTO.setAuteur(userFactory.getUserDTO(userService.getUserById(commentaire.getIdUser())));
            commentaireDTO.setOwned(userService.getCurrentUser().getId() == commentaire.getIdUser());
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
