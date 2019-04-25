package myapp.service;

import myapp.model.Association;

import java.util.List;

public interface AssociationService {
    List<Association> getAssociationsByIdProduct(String id_association) throws Exception;

    String deleteAssociation(String id_association) throws Exception;
}
