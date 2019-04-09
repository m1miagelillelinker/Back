package myapp.business.impl;

import myapp.business.AssociationBusiness;
import myapp.model.Produit;
import myapp.service.AssociationService;
import myapp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssociationBusinessImpl implements AssociationBusiness {

    private final AssociationService associationService;
    private final ProduitService produitService;

    @Autowired
    public AssociationBusinessImpl(AssociationService associationService, ProduitService produitService) {
        this.associationService = associationService;
        this.produitService = produitService;
    }



    @Override
    public List<Produit> findAllAssociateProduct(String id_product) {
        List<Produit> listProduit = new ArrayList<>();
        return listProduit;

    }
}
