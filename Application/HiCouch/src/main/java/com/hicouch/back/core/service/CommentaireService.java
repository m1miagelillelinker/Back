package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Commentaire;

import java.util.List;

public interface CommentaireService {

    List<Commentaire> findAllByIdUser(int idUser);
    List<Commentaire> findAllByIdAssoc(int idAssoc);
    Commentaire findById(int id);
}
