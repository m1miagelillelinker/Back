package myapp.service.impl;

import myapp.repository.AssociationRepository;
import myapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationServiceImpl implements AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

}
