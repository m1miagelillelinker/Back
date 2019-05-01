package myapp.service;

import myapp.model.Signalement;

import java.util.List;

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
}
