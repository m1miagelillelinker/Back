package com.hicouch.back.core.service;

import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Association;

import java.util.List;
import java.util.Optional;

public interface AssociationService {
    List<AssociationDTO> getAssociationsByIdProduct(String idAssociation) throws BusinessException;

    AssociationDTO getAssociationByIdPair(int idPair);

    boolean checkIfIdPairExists(int idPair);

    List<AssociationDTO> getTopLastAssociations() throws Exception;

    String deleteAssociation(int idAssociation) throws Exception;

    int countAssosByIdUser(int iduser);
    
    Optional<Association> getAssociationByProduitAAndB(String idProduitA, String idProduitB);
    
    Association saveAssociation(Association association);

    List<Association> getAssociationByIdPaire(int idPair);

    List<Association> getAllAssociationByIdUser(int userId);
}
