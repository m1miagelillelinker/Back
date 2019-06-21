package com.hicouch.back.core.business;

import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Historique;

import java.util.List;

public interface HistoriqueBusiness {
    List<HistoriqueDTO> getHistoriqueByIdUser(Integer id) throws NoResultException;
}
