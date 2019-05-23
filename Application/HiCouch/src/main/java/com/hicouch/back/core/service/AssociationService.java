package com.hicouch.back.core.service;

import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.model.Association;

import java.util.List;

public interface AssociationService {
    List<AssociationDTO> getAssociationsByIdProduct(String idAssociation) throws Exception;

    List<AssociationDTO> getAssociationByIdPair(int idPair);

    String deleteAssociation(int idAssociation) throws Exception;

	Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB)
			throws Exception;
}
