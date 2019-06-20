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
    public Historique createHistorique(int id, int idUser, String type) {
        Historique historique = new Historique(id,idUser,type);
        historiqueRepository.save(historique);
        return historique;
    }

    @Override
    public List<Historique> getHistoriquesByUserId(int userId) {
        return historiqueRepository.findAllByIdUser(userId);
    }

    @Override
    public List<Historique> getHistoriquesByUserIdAndType(int userId, String type){
        return historiqueRepository.findAllByIdUserAndType(userId,type);
    }


}
