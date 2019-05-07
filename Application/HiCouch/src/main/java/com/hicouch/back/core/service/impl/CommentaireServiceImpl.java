package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.repository.CommentaireRepository;
import com.hicouch.back.core.service.CommentaireService;
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
        Optional<List<Commentaire>> listCommentaires = commentaireRepository.findAllByIdUser(idUser);
        return listCommentaires.get().size() != 0 ? listCommentaires.get() : new ArrayList<>();
    }

    @Override
    public List<Commentaire> findAllByIdAssoc(int idAssoc) {
        Optional<List<Commentaire>> listCommentaires = commentaireRepository.findAllByIdAssoc(idAssoc);
        return listCommentaires.get().size() != 0 ? listCommentaires.get() : new ArrayList<>();
    }

    @Override
    public Commentaire findById(int id) {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        return commentaire.orElse(null);
    }
}
