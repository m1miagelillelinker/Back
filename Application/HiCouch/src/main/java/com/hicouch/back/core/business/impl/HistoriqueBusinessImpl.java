package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.*;
import com.hicouch.back.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HistoriqueBusinessImpl implements HistoriqueBusiness {

    private HistoriqueService historiqueService;
    private BadgeService badgeService;
    private UserService userService;
    private AssociationService associationService;
    private CommentaireService commentaireService;
    private AbonnementService abonnementService;

    @Autowired
    public HistoriqueBusinessImpl(HistoriqueService historiqueService, UserService userService, BadgeService badgeService, AssociationService associationService, CommentaireService commentaireService){
        this.historiqueService = historiqueService;
        this.userService = userService;
        this.badgeService = badgeService;
        this.associationService = associationService;
        this.commentaireService = commentaireService;
    }


    @Override
    public List<HistoriqueDTO> getHistoriqueByIdUser(Integer id) {
        //TODO: historique
        return new ArrayList<>();
    }
}
