package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Historique;

import java.util.Date;
import java.util.List;

public interface HistoriqueService {

    Historique createHistorique(int idUser,String pseudo,String evenement);
}
