package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.DataProvidedException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.UserService;
import com.hicouch.back.core.service.impl.AssociationServiceImpl;
import com.hicouch.back.core.service.impl.CommentaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentaireBusinessImpl implements CommentaireBusiness {

    private CommentaireService commentaireService;
    private AssociationService associationService;
    private UserService userService;

    @Autowired
    public CommentaireBusinessImpl(CommentaireService commentaireService, AssociationService associationService, UserService userService) {
        super();
        this.userService = userService;
        this.commentaireService = commentaireService;
        this.associationService = associationService;
    }

    //TODO Faire en sorte que le SPAM ne soit pas possible (limiter le nombre de commentaires par minute par exemple
    public Commentaire addCommentaire(Commentaire commentaire) throws BusinessException, DataProvidedException {
        if ( ! associationService.checkIfIdPairExists(commentaire.getIdPair())){
            throw new BusinessException();
        }
        commentaire.setIdUser(userService.getCurrentUser().getId());
        return commentaireService.addCommentaire(commentaire);

    }


}
