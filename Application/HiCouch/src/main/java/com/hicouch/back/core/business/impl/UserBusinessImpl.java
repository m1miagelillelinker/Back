package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.business.UserBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {

    private UserService userService;
    private AssociationService associationService;
    private CommentaireService commentaireService;

    @Autowired
    public UserBusinessImpl(UserService userService,AssociationService associationService,CommentaireService commentaireService){
        this.userService = userService;
        this.associationService = associationService;
        this.commentaireService = commentaireService;
    }


    @Override
    public User getUserById(int userId) throws NoResultException {
        User user;
        try {
            user = userService.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoResultException();
        }

        List<Association> associationList = associationService.getAllAssociationByIdUser(userId);
        List<Commentaire> commentaireList = commentaireService.findAllByIdUser(userId);

        int score = 0;

        for(Association association : associationList){
            score += association.getNote();
        }
        score = score/2;

        for(Commentaire commentaire : commentaireList){
            score += commentaire.getNote();
        }
        user.setScore(score);
        return user;
    }
}
