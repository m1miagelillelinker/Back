package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.repository.CommentaireRepository;
import com.hicouch.back.core.service.CommentaireService;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {


    private final CommentaireRepository commentaireRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public List<Commentaire> getAllCommentairesToModerate() {
		return commentaireRepository.findAllByStatus(StatusEnum.TO_MODERATE);
	}

	@Override
	public Commentaire setCommentaireStatus(int commentId, int status) throws NoResultException {
		Commentaire commentaire = commentaireRepository.findById(commentId).orElseThrow(NoResultException::new);
		commentaire.setStatus(status);
		return commentaireRepository.save(commentaire);
	}

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) throws BusinessException {
        try{
            commentaire.setCreatedat(new Date());
            commentaire.setUpdatedAt(new Date());
            commentaire.setNote(commentaire.getNote()+1);
            commentaire.setStatus(StatusEnum.TO_MODERATE);
            logger.trace(commentaire.toString());
            return commentaireRepository.save(commentaire);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new BusinessException("Idpair inexistant");
        }
    }

    @Override
    public Commentaire hideCommentaire(Commentaire commentaire) throws NoResultException {
        if(commentaire.getId() != null) {
            Commentaire oldCommentaire = findById(commentaire.getId());
            oldCommentaire.setStatus(StatusEnum.HIDDEN);
            commentaire = oldCommentaire;
            commentaire.setUpdatedAt(new Date());
            return commentaireRepository.save(commentaire);
        }
        else return null;
    }

    @Override
    public Commentaire updateCommentaire(Commentaire json) throws NoResultException {
        return upsertCommentaire(json);

    }

    @Override
    public Commentaire upsertCommentaire(Commentaire commentaire) throws NoResultException {
        if(commentaire.getId() != null) {
            Commentaire oldCommentaire = findById(commentaire.getId());
            oldCommentaire.setCommentaire(commentaire.getCommentaire());
            commentaire = oldCommentaire;
        } else {
            commentaire.setCreatedat(new Date());
        }
        commentaire.setUpdatedAt(new Date());
        return commentaireRepository.save(commentaire);
    }


}
