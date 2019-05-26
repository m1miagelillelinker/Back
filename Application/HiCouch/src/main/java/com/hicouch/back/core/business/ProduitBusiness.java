package com.hicouch.back.core.business;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;

import java.util.List;

public interface ProduitBusiness {

	public ProductDTO getCompleteProduct(String idProduct, String referentiel) throws Exception;

	
}
