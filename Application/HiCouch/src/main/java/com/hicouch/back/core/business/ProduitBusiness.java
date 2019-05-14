package com.hicouch.back.core.business;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;

public interface ProduitBusiness {

	public ProductDTO getCompleteProduct(String idProduct, String referentiel) throws Exception;
	
}
