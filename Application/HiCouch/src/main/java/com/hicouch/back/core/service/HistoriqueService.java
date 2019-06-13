package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Historique;

import java.util.Date;
import java.util.List;

public interface HistoriqueService {
    List<Historique> getHistoriqueByIdUser(int id);
    Historique createHistorique(int idUser,List<String> listevent, Date date,String pseudo);
}
