package com.hicouch.back.core.service;

import com.hicouch.back.core.model.TagProduit;

import java.util.List;

public interface TagProduitService {

	TagProduit createOrGetTagProduit(int idTag, String idProduit);
	
	List<TagProduit> findAllTagProduitByIdProduit(String idProduit);
	
}
