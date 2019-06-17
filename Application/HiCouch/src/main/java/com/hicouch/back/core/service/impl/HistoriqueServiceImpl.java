package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.repository.HistoriqueRepository;
import com.hicouch.back.core.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public HistoriqueServiceImpl(HistoriqueRepository historiqueRepository){
        this.historiqueRepository = historiqueRepository;
    }


    @Override
    public Historique getHistoriqueByIdUser(int id) {
        return historiqueRepository.findById(id).get();
    }

    @Override
    public Historique createHistorique(int id, List<String> listevent,String pseudo) {
        Historique historique = new Historique(id,pseudo,listevent);
        historiqueRepository.save(historique);
        return historique;
    }

    @Override
    public void addToHistorique(String event, int id) {
        Historique historique = this.getHistoriqueByIdUser(id);
        List<String> lvent = historique.getEvenements();
        lvent.add(event);

        historique.setEvenements(lvent);
        historiqueRepository.save(historique);
    }


}
