package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.repository.SignalementRepository;
import com.hicouch.back.core.service.SignalementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalementServiceImpl implements SignalementService {


    private final SignalementRepository signalementRepository;

    @Autowired
    public SignalementServiceImpl(SignalementRepository signalementRepository) {
        this.signalementRepository = signalementRepository;
    }

    @Override
    public Signalement getSignalementById(Integer signalementId) throws NoResultException{
        return signalementRepository.findById(signalementId).orElseThrow(NoResultException::new);
    }

    /**
     * TODO : implémenter
     */
    @Override
    public Signalement createSignalement(String typeSignalement, int signaledId, String message, int idSignalement, int status, int moderatorId) {
        //Signalement result = signalementRepository.save(new Signalement(typeSignalement, signaledId, message, idSignalement, moderatorId));
        return null;
    }

    @Override
    public Signalement createSignalement(Signalement signalement) {
        return signalementRepository.save(signalement);
    }

	@Override
	public List<Signalement> findAllSignalementsInStatus(int status) {
		return signalementRepository.findAllByStatus(status);
	}
}
