package myapp.service.impl;

import myapp.model.Signalement;
import myapp.repository.SignalementRepository;
import myapp.service.SignalementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementServiceImpl implements SignalementService {


    private final SignalementRepository signalementRepository;

    @Autowired
    public SignalementServiceImpl(SignalementRepository signalementRepository) {
        this.signalementRepository = signalementRepository;
    }

    @Override
    public Signalement getSignalementById(Integer id) {
        return signalementRepository.findById(id).get();
    }

    @Override
    public Signalement createSignalement(String typeSignalement, int signaledId, String message, int idUser, int status, int moderatorId) {
        Signalement result = signalementRepository.save(new Signalement(typeSignalement, signaledId, message, idUser, moderatorId));
        return result;
    }

    @Override
    public Signalement createSignalement(Signalement signalement) {
        Signalement result = signalementRepository.save(signalement);
        return result;
    }
}
