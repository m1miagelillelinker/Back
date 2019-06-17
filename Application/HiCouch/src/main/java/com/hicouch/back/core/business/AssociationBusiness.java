package com.hicouch.back.core.business;

import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Association;

public interface AssociationBusiness {
    Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB) throws BusinessException;
}
