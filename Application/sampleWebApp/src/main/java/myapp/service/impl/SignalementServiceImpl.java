package myapp.service.impl;

import myapp.model.Signalement;
import myapp.model.Signalement;
import myapp.repository.SignalementRepository;
import myapp.service.SignalementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignalementServiceImpl implements SignalementService {


    private final SignalementRepository signalementRepository;

    @Autowired
    public SignalementServiceImpl(SignalementRepository signalementRepository) {
        this.signalementRepository = signalementRepository;
    }

    @Override
    public Signalement getSignalementById(Integer id) {
        try{
            Signalement t = signalementRepository.find
        }
    }

    /*
    public Signalement getSignalementById(Integer signalementId) throws Exception {
        Optional<Signalement> rep = signalementRepository.findById(signalementId);
        if(rep.isPresent()){
            return rep.get();
        }else{
            throw new Exception();
        }
    }*/



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
}
