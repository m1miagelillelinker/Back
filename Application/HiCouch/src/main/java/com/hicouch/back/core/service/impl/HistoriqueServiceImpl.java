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
    public List<Historique> getHistoriqueByIdUser(int id) {
        return historiqueRepository.findAllByIdUser(id);
    }

    @Override
    public Historique createHistorique(int id, List<String> listevent,Date date,String pseudo) {
        Historique historique = new Historique(id,listevent,date,pseudo);
        historiqueRepository.save(historique);
        return historique;
    }




}
