package com.hicouch.back.core.business;

import com.hicouch.back.core.model.Historique;

import java.util.List;

public interface HistoriqueBusiness {
    List<Historique> getHistoriqueByIdUser(Integer id);
}
