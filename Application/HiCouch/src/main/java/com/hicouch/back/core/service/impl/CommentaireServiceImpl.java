package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.repository.CommentaireRepository;
import com.hicouch.back.core.service.CommentaireService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentaireService {


    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

	@Override
	public List<Commentaire> getCommentaireByAsso(int idPair) {
		return this.commentaireRepository.findAllByIdPair(idPair);
	}
    
    
}
