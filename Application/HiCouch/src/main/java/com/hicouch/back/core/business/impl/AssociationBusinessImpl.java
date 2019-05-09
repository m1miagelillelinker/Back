package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationBusinessImpl implements AssociationBusiness {

    private final AssociationService associationService;
    private final ProduitService produitService;

    @Autowired
    public AssociationBusinessImpl(AssociationService associationService, ProduitService produitService) {
        this.associationService = associationService;
        this.produitService = produitService;
    }

}
