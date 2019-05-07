package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.factory.AssociationFactory;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;
    private final EntityManager entityManager;
    private final AssociationFactory associationFactory;

    @Autowired
    public AssociationServiceImpl(AssociationRepository associationRepository, EntityManager entityManager, AssociationFactory associationFactory) {
        this.associationRepository = associationRepository;
        this.entityManager = entityManager;
        this.associationFactory = associationFactory;
    }

    @Override
    public List<AssociationDTO> getAssociationsByIdProduct(String idProduct) throws Exception {
    	List<Association> listAsso;
    	List<AssociationDTO> listAssoDTO;

        try{
            listAsso = associationRepository.findAllByidproduitA(idProduct);
        }catch (Exception e){
            throw new Exception();
        }
        
        return listAsso.stream().map(associationFactory::getAssociationDTO).collect(Collectors.toList());

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

        Query q = entityManager.createNativeQuery("SELECT NEXT VALUE FOR dbo.assocouple");
        int idPair = (Integer)q.getSingleResult();

        Association asso = new Association();
        asso.setIdproduitA(idProductA);
        asso.setIdproduitB(idProductB);
        asso.setIdPair(idPair);
        asso.setCreatedat(maintenant);
        asso.setUpdatedat(maintenant);
        
        Association assoMirror = new Association();
        assoMirror.setIdproduitA(idProductB);
        assoMirror.setIdproduitB(idProductA);
        assoMirror.setIdPair(idPair);
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
