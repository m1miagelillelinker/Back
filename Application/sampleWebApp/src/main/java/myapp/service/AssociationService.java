package myapp.service;

import myapp.model.Association;

public interface AssociationService {
    Association getAssociationById(String id_association) throws Exception;
}
