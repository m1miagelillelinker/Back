package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.HistoriqueFactory;
import com.hicouch.back.core.model.*;
import com.hicouch.back.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoriqueBusinessImpl implements HistoriqueBusiness {

    private HistoriqueService historiqueService;
    private BadgeService badgeService;
    private UserService userService;
    private AbonnementService abonnementService;
    private HistoriqueFactory historiqueFactory;

    @Autowired
    public HistoriqueBusinessImpl(HistoriqueService historiqueService, UserService userService, BadgeService badgeService,AbonnementService abonnementService){
        this.historiqueService = historiqueService;
        this.userService = userService;
        this.badgeService = badgeService;
        this.abonnementService = abonnementService;
    }

    @Override
    public List<HistoriqueDTO> getHistoriqueByIdUser(Integer id) throws NoResultException {
        User user = userService.getCurrentUser();

        if(id != 5){
            return historiqueFactory.convertCommentaires( historiqueService.getHistoriquesByUserId(id));
        }else{
            List<Historique> historiqueList = new ArrayList<>();
            //List<Abonnement> listabo = abonnementService.getFollowsByFollower(user.getId());

            List<Abonnement> listabo = abonnementService.getFollowsByFollower(5);
            listabo.stream()
            .map((abonnement -> abonnement.getFollows())).map(historiqueService::getHistoriquesByUserId).map(historiqueList::addAll).collect(Collectors.toList());


            historiqueList.sort((o1, o2) -> o1.getId() - o2.getId());

            historiqueList.forEach(h -> System.out.println(h));
            return historiqueFactory.convertCommentaires(historiqueList);
        }
    }
}
