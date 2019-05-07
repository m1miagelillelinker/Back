package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Commentaire;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Integer> {
	
	List<Commentaire> findAllByIdPair(int idpair);
}
