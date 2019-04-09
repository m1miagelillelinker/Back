package myapp.business;

import myapp.model.Produit;

import java.util.List;

public interface AssociationBusiness {
    List<Produit> findAllAssociateProduct(String id_product);
}
