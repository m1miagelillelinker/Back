package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;

    @Autowired
    public AssociationServiceImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public List<Association> getAssociationsByIdProduct(String idProduct) throws Exception {
        List<Association> listAsso;

        try{
            listAsso = associationRepository.findAllByidproduitA(idProduct);
        }catch (Exception e){
            throw new Exception();
        }
        return listAsso;

    }

    @Override
    public String deleteAssociation(int idAssociation) throws Exception {
        try{
            associationRepository.deleteById(idAssociation);
        }catch (Exception e){
            throw new Exception();
        }
        return "Le delete a ete fait";
    }

    @Override
    public Association createAssociation(String idProductA, String idProductB) throws Exception {

        Date maintenant = new Date(System.currentTimeMillis());

        Association asso = new Association();
        asso.setIdproduitA(idProductA);
        asso.setIdproduitB(idProductB);
        asso.setCreatedat(maintenant);
        asso.setUpdatedat(maintenant);
        
        Association assoMirror = new Association();
        assoMirror.setIdproduitA(idProductB);
        assoMirror.setIdproduitB(idProductA);
        assoMirror.setCreatedat(maintenant);
        assoMirror.setUpdatedat(maintenant);

        try{
            associationRepository.save(asso);
            associationRepository.save(assoMirror);
        }catch (Exception e){
        	e.printStackTrace();
            throw new Exception();
        }
        return asso;
    }
}
