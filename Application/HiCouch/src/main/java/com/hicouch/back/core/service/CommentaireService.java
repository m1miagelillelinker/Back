package com.hicouch.back.core.service;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;

import java.util.List;

public interface CommentaireService {

    List<Commentaire> findAllByIdUser(int idUser);
    Commentaire findById(int id) throws NoResultException;
	List<Commentaire> getCommentaireByAsso(int idAsso);
	List<Commentaire> getAllCommentairesToModerate();
	Commentaire setCommentaireStatus(int commentId, int status) throws NoResultException;
	
}
