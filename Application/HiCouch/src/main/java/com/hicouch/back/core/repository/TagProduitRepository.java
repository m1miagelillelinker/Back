package com.hicouch.back.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hicouch.back.core.model.TagProduit;

public interface TagProduitRepository extends CrudRepository<TagProduit,Integer> {
	
	List<TagProduit> findAllByIdProduit(String idProduit);

}
