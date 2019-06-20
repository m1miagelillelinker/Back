package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.TagProduit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagProduitRepository extends CrudRepository<TagProduit,Integer> {
	
	List<TagProduit> findAllByIdProduit(String idProduit);
	
	Optional<TagProduit> findByIdProduitAndIdTag(String idProduit, int idTag);

}
