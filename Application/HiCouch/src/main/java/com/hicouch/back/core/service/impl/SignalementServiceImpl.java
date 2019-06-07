package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.SignalementFactory;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.repository.SignalementRepository;
import com.hicouch.back.core.service.SignalementService;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalementServiceImpl implements SignalementService {


    private final SignalementRepository signalementRepository;
	private final SignalementFactory signalementFactory;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SignalementServiceImpl(SignalementRepository signalementRepository, SignalementFactory signalementFactory) {
        this.signalementRepository = signalementRepository;
        this.signalementFactory = signalementFactory;
    }

    @Override
    public Signalement getSignalementById(Integer signalementId) throws NoResultException {
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
	public List<SignalementDTO> findAllSignalementsInStatus(int status) {
		return signalementRepository.findAllByStatus(status)
				.stream()
				.map(signalementFactory::getSignalementDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<SignalementDTO> findAllSignalementsByTypeAndStatus(int status, String type) {
		return signalementRepository.findAllByStatusAndTypeSignalement(status, type)
				.stream()
				.map(signalementFactory::getSignalementDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Signalement setSignalementStatus(int signalementId, int status) throws NoResultException {
		Signalement signalement = signalementRepository.findById(signalementId).orElseThrow(NoResultException::new);
		signalement.setStatus(status);
		return signalementRepository.save(signalement);
	}
}
