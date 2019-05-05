package com.hicouch.back.core.service.impl;

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
    /*public Signalement getSignalementById(Integer id) {
        try{
            Signalement t = signalementRepository.find;
        }
    }*/
    public Signalement getSignalementById(Integer signalementId){
        return signalementRepository.findById(signalementId).get();
    }



    @Override
    public Signalement createSignalement(String typeSignalement, int signaledId, String message, int idSignalement, int status, int moderatorId) {
        //Signalement result = signalementRepository.save(new Signalement(typeSignalement, signaledId, message, idSignalement, moderatorId));
        return null;
    }

    @Override
    public Signalement createSignalement(Signalement signalement) {
        Signalement result = signalementRepository.save(signalement);
        return result;
    }

	@Override
	public List<Signalement> findAllSignalementsInStatus(int status) {
		return signalementRepository.findAllByStatus(status);
	}
}
