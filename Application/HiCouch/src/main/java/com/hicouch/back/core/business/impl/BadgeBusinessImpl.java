package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.BadgeBusiness;
import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.model.Badge;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.BadgeService;
import com.hicouch.back.core.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeBusinessImpl implements BadgeBusiness {

    private CommentaireService  commentaireService;
    private AssociationService  associationService;
    private BadgeService        badgeService;

    @Autowired
    public BadgeBusinessImpl(CommentaireService commentaireService, AssociationService associationService, BadgeService badgeService) {
        this.commentaireService = commentaireService;
        this.associationService = associationService;
        this.badgeService = badgeService;
    }

    public List<Badge> getUserBadges(Integer iduser) {
        List<Badge> badges = badgeService.findAll();
        for (Badge badge: badges ) {
            switch (badge.getApplyOn()) {
                case "association":
                    if (badge.getSeuil() < associationService.countAssosByIdUser(iduser))
                        badge.setStatus(StatusEnum.OK);
                    break;
                case "commentaire":
                    if (badge.getSeuil() < commentaireService.countCommentairesByIdUser(iduser))
                        badge.setStatus(StatusEnum.OK);
                    break;
            }

        }

        return badges;

    }
}
