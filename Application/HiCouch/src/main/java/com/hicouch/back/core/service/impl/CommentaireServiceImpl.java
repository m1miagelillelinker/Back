package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.CommentaireRepository;
import com.hicouch.back.core.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentaireService {


    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }
}
