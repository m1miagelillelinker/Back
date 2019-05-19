package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Signalement;

public interface SignalementService {

    Signalement getSignalementById(Integer id) throws NoResultException;

    Signalement createSignalement(Signalement signalement);

    Signalement createSignalement(String typeSignalement, int signaledId, String message, int idUser, int status, int moderatorId);

    /*
     * TODO :
     * validation de signalements
     * maj de signalements
     *
     */

    List<SignalementDTO> findAllSignalementsInStatus(int status);

	List<SignalementDTO> findAllSignalementsByTypeAndStatus(int status, String type);

	Signalement setSignalementStatus(int signalementId, int status) throws NoResultException;
}
