package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.repository.CommentaireRepository;
import com.hicouch.back.core.service.CommentaireService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {


    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    @Override
    public List<Commentaire> findAllByIdUser(int idUser) {
    	return commentaireRepository.findAllByIdUser(idUser);
    }

    @Override
    public Commentaire findById(int id) throws NoResultException {
        return commentaireRepository.findById(id).orElseThrow(NoResultException::new);
    }

	@Override
	public List<Commentaire> getCommentaireByAsso(int idPair) {
		return commentaireRepository.findAllByIdPair(idPair);
	}

	@Override
	public List<Commentaire> getAllTagsToModerate() {
		return commentaireRepository.findAllByStatus(StatusEnum.TO_MODERATE);
	}
    
    
}
