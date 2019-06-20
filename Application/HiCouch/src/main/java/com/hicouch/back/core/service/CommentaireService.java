package com.hicouch.back.core.service;

import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;

import java.util.List;

public interface CommentaireService {

    List<Commentaire> findAllByIdUser(int idUser);
    Commentaire findById(int id) throws NoResultException;
	List<Commentaire> getCommentaireByAsso(int idAsso);
	List<Commentaire> getAllCommentairesToModerate();
	Commentaire setCommentaireStatus(int commentId, int status) throws NoResultException;

    Commentaire addCommentaire(Commentaire commentaire) throws BusinessException;

    Commentaire hideCommentaire(Commentaire commentaire) throws NoResultException;

    Commentaire updateCommentaire(Commentaire commentaire) throws NoResultException;

    Commentaire upsertCommentaire(Commentaire commentaire) throws NoResultException;

    int countCommentairesByIdUser(Integer iduser);
}
