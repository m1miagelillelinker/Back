package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.Signalement;

public interface SignalementService {

    Signalement getSignalementById(Integer id);

    Signalement createSignalement(Signalement signalement);

    Signalement createSignalement(String typeSignalement, int signaledId, String message, int idUser, int status, int moderatorId);

    /*
     * TODO :
     * validation de signalements
     * maj de signalements
     *
     */
    
    List<Signalement> findAllSignalementsInStatus(int status);
}