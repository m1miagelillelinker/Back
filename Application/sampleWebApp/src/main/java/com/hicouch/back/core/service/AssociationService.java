package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Association;

import java.util.List;

public interface AssociationService {
    List<Association> getAssociationsByIdProduct(String id_association) throws Exception;

    String deleteAssociation(String id_association) throws Exception;

    Association createAssociation(String id_association_1, String id_association_2) throws Exception;
}
