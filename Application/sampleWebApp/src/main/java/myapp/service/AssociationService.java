package myapp.service;

import myapp.model.Association;

import java.util.List;

public interface AssociationService {
    List<Association> getAssociationsByIdProduct(String id_association) throws Exception;

    String deleteAssociation(String id_association) throws Exception;

    Association createAssociation(String id_association_1, String id_association_2) throws Exception;
}
