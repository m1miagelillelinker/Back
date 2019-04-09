package myapp.controller;

import myapp.business.AbonnementBusiness;
import myapp.model.Abonnement;
import myapp.model.User;
import myapp.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/abonnement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AbonnementController {

    private final AbonnementBusiness abonnementBusiness;
    private final AbonnementService abonnementService;


    @Autowired
    public AbonnementController(AbonnementBusiness abonnementBusiness, AbonnementService abonnementService){
        this.abonnementBusiness = abonnementBusiness;
        this.abonnementService = abonnementService;
    }


}
