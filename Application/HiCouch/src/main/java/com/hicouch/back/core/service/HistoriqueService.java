package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Historique;

public interface HistoriqueService {

    Historique createHistorique(int id, int idUser, String type);
}
