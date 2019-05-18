package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.TagProduit;

public interface TagProduitService {

	TagProduit createOrGetTagProduit(int idTag, String idProduit);
	
	List<TagProduit> findAllTagProduitByIdProduit(String idProduit);
	
}
