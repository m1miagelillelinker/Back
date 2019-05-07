package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Commentaire;
import java.util.List;

public interface CommentaireService {

    List<Commentaire> findAllByIdUser(int idUser);
    Commentaire findById(int id);
	List<Commentaire> getCommentaireByAsso(int idAsso);
	
}
