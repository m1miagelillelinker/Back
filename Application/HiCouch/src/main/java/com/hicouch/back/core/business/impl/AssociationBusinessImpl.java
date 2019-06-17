package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationBusinessImpl implements AssociationBusiness {

    private final AssociationService associationService;
    private final ProduitService produitService;
    private final HistoriqueService historiqueService;
    private final UserService userService;

    @Autowired
    public AssociationBusinessImpl(AssociationService associationService, ProduitService produitService , HistoriqueService historiqueService,UserService userService) {
        this.associationService = associationService;
        this.produitService = produitService;
        this.historiqueService = historiqueService;
        this.userService = userService;
    }

    @Override
    public Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB) throws BusinessException {
        Association association = associationService.createAssociation(idProductA,idfournA,idProductB,idfournB);
        historiqueService.addToHistorique(association.toString(),userService.getCurrentUser().getId());
        return association;
    }
}
