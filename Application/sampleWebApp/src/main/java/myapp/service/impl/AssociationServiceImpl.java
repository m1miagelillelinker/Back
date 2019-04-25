package myapp.service.impl;

import myapp.model.Association;
import myapp.repository.AssociationRepository;
import myapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;

    @Autowired
    public AssociationServiceImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public List<Association> getAssociationsByIdProduct(String id_association) throws Exception {
        List<Association> listAsso;

        try{
            listAsso = associationRepository.findAllById_produit_A(id_association);
        }catch (Exception e){
            throw new Exception();
        }

        return listAsso;


    }

    @Override
    public String deleteAssociation(String id_association) throws Exception {
        try{
            associationRepository.deleteById(id_association);
        }catch (Exception e){
            throw new Exception();
        }
        return "Le delete a ete fait";
    }


}
