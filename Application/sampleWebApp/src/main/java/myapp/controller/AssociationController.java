package myapp.controller;

import myapp.business.AssociationBusiness;
import myapp.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/association" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AssociationController {

    @Autowired
    private AssociationBusiness associationBusiness;

    @Autowired
    private AssociationService associationService;
}