package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.Commentaire;

public interface CommentaireService {
	
	List<Commentaire> getCommentaireByAsso(int idAsso);
	
}
