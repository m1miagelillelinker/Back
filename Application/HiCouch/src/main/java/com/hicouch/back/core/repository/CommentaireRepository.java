package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Integer> {

    Optional<List<Commentaire>> findAllByIdUser (int idUser);

    Optional<List<Commentaire>> findAllByIdAssoc (int idAssoc);

    Optional<Commentaire> findById( int id);


}
