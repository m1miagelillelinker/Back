package com.hicouch.back.core.factory;

import com.hicouch.back.core.controller.CommentaireController;
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

@Component
public class CommentaireFactory {

    private UserService userService;
    private UserFactory userFactory;
    private CommentaireService commentaireService;
    private AssociationService associationService;
    private final static Logger logger = LoggerFactory.getLogger(CommentaireController.class);

    @Autowired
    public CommentaireFactory(UserService userService, AssociationService associationService, UserFactory userFactory, CommentaireService commentaireService) {
        super();
        this.userService        = userService;
        this.userFactory        = userFactory;
        this.commentaireService = commentaireService;
        this.associationService = associationService;
    }

    public CommentaireDTO getCommentaireDTO(Commentaire commentaire) {
        logger.trace("getCommentaireDTO:"+commentaire);

        CommentaireDTO commentaireDTO = new CommentaireDTO();

        commentaireDTO.setAssociation(associationService.getAssociationByIdPair(commentaire.getIdPair()));
        try {
            commentaireDTO.setAuteur(userFactory.getUserDTO(userService.getUserById(commentaire.getIdUser())));
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        commentaireDTO.setCommentaire(commentaire);



        return commentaireDTO;
    }

    public List<CommentaireDTO> convertCommentaires(List<Commentaire> commentaires){
        List<CommentaireDTO> outList= new ArrayList<>();
        for (Commentaire commentaire:commentaires) {
            outList.add(getCommentaireDTO(commentaire));
        }
        return outList;
    }
}
