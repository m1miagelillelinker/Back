package myapp.service.impl;

import myapp.model.Association;
import myapp.repository.AssociationRepository;
import myapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public List<Association> getAssociationsByIdProduct(String id_association) throws Exception {
        List<Association> listAsso;

        try{
            listAsso = associationRepository.findAllByidproduitA(id_association);
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

    @Override
    public Association createAssociation(String id_association_1, String id_association_2) throws Exception {

        Date maintenant = new Date(System.currentTimeMillis());

        Association asso = new Association();
        asso.setIdproduitA(id_association_1);
        asso.setIdproduitB(id_association_2);
        asso.setCreatedat(maintenant);
        asso.setUpdatedat(maintenant);

        try{
            associationRepository.save(asso);
        }catch (Exception e){
            throw new Exception();
        }
        return asso;
    }
}
