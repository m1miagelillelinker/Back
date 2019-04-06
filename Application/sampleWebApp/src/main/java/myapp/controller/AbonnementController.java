package myapp.controller;

import myapp.business.AbonnementBusiness;
import myapp.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/abonnement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AbonnementController {

    @Autowired
    private AbonnementBusiness abonnementBusiness;
    
    @Autowired
    private AbonnementService abonnementService;

}
