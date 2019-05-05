package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Association;

import java.util.List;

public interface AssociationService {
    List<Association> getAssociationsByIdProduct(String id_association) throws Exception;

    String deleteAssociation(int idAssociation) throws Exception;

    Association createAssociation(String idProduitA, String idProduitB) throws Exception;
}
