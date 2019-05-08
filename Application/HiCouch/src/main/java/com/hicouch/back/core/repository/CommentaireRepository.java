package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Commentaire;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Integer> {

    List<Commentaire> findAllByIdUser (int idUser);

    Optional<Commentaire> findById( int id);
	
	List<Commentaire> findAllByIdPair(int idpair);
}
