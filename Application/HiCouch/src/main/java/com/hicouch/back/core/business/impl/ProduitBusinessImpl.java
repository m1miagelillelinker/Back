package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitBusinessImpl implements ProduitBusiness {
	
	@Autowired
	private ProduitService produitService;

	@Autowired
	TagBusiness tagBusiness;
	
	@Autowired
	public ProduitBusinessImpl(ProduitService produitService, TagBusiness tagBusiness) {
		super();
		this.produitService = produitService;
		this.tagBusiness = tagBusiness;
	}

	public ProductDTO getCompleteProduct(String idProduct, String referentiel) throws Exception {
		ProductDTO product = produitService.getProductByIdFromReferentiel(idProduct, referentiel);
		product.setTags(tagBusiness.getAllTagByProduct(idProduct));
		return product;
	}

}
