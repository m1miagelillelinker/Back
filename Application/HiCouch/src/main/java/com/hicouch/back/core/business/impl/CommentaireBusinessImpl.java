package com.hicouch.back.core.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.UserService;


public class CommentaireBusinessImpl implements CommentaireBusiness {
	
    private UserService userService;
    private CommentaireService commentaireService;
    private AssociationService associationService;
    private HistoriqueService historiqueService;
    
    @Autowired
    public CommentaireBusinessImpl(CommentaireService commentaireService, AssociationService associationService, UserService userService, HistoriqueService historiqueService) {
        this.commentaireService = commentaireService;
        this.associationService = associationService;
        this.userService = userService;
        this.historiqueService = historiqueService;
    }

    //TODO Faire en sorte que le SPAM ne soit pas possible (limiter le nombre de commentaires par minute par exemple
    public Commentaire addCommentaire(Commentaire commentaire) throws BusinessException {
        if ( ! associationService.checkIfIdPairExists(commentaire.getIdPair())){
            throw new BusinessException();
        }

        Commentaire commentaire1 = commentaireService.addCommentaire(commentaire);
        return commentaire1;
    }

}
