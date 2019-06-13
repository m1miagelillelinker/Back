package com.hicouch.back.core.business;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.exception.BusinessException;

import java.util.List;

public interface ProduitBusiness {

	ProductDTO getCompleteProduct(String idProduct, String referentiel) throws BusinessException;

    List<ProductDTO> getCompleteProducts(String keyword,String referentiel) throws BusinessException;

	
}
