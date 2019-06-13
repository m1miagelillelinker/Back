package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueBusinessImpl implements HistoriqueBusiness {

    private HistoriqueService historiqueService;
    private UserService userService;

    @Autowired
    public HistoriqueBusinessImpl(HistoriqueService historiqueService, UserService userService){


    }


    @Override
    public Historique createHistorique(String id) throws NoResultException {
        userService.getUserById(Integer.parseInt(id));
    }
}
