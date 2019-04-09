package myapp.service.impl;

import myapp.model.Association;
import myapp.repository.AssociationRepository;
import myapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;

    @Autowired
    public AssociationServiceImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public Association getAssociationById(String id_association) throws Exception {
        Optional<Association> association;
        try{
            association = associationRepository.findById(Integer.parseInt(id_association));
        }catch (Exception e){
            throw new Exception();
        }

        if(association.isPresent()){
            return association.get();
        }else{
            throw  new Exception();
        }
    }


}
