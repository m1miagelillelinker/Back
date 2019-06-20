package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Historique;

import java.util.List;

public interface HistoriqueService {

    Historique createHistorique(int id, int idUser, String type);

    List<Historique> getHistoriquesByUserId(int userId);

    List<Historique> getHistoriquesByUserIdAndType(int userId, String type);
}
