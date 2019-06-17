package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Historique;

import java.util.Date;
import java.util.List;

public interface HistoriqueService {
    Historique getHistoriqueByIdUser(int id);
    Historique createHistorique(int idUser,List<String> listevent,String pseudo);

    void addToHistorique(String event, int id);
}
