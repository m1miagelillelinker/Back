package com.hicouch.back.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hicouch.back.core.model.TagProduit;

public interface TagProduitRepository extends CrudRepository<TagProduit,Integer> {
	
	List<TagProduit> findAllByIdProduit(String idProduit);
	
	Optional<TagProduit> findByIdProduitAndIdTag(String idProduit, int idTag);

}
