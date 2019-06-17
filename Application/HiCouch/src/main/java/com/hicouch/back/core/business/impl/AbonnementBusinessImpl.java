package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AbonnementService;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AbonnementBusinessImpl implements AbonnementBusiness {

    private AbonnementService abonnementService;
    private HistoriqueService historiqueService;
    private UserService userService;

    public AbonnementBusinessImpl(AbonnementService abonnementService, HistoriqueService historiqueService, UserService userService){
        this.abonnementService = abonnementService;
        this.historiqueService = historiqueService;
        this.userService = userService;
    }



    @Override
    public Abonnement follow(Integer follower, Integer follows) {
        Abonnement abonnement = abonnementService.follow(follower,follows);
        historiqueService.addToHistorique("Abonnement : "+abonnement.getFollows(),userService.getCurrentUser().getId() );
        return abonnement;
    }
}
