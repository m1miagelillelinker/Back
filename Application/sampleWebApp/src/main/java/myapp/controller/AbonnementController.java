package myapp.controller;

import myapp.business.AbonnementBusiness;
import myapp.model.Abonnement;
import myapp.model.User;
import myapp.service.AbonnementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/abonnement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AbonnementController {

    @Autowired
    private AbonnementBusiness abonnementBusiness;
    
    @Autowired
    private AbonnementService abonnementService;
    
    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public List<Abonnement> getUserById(@RequestParam("userId") String userId){
        System.out.println(userId);

        List<Abonnement> abonnements = abonnementService.getFollowersById(Integer.parseInt(userId));

        return abonnements;
    }
    
    // get all followers
    
    // get all followed by
    
    // get A follow B
    
    // put A follow B 
    
    // delete A follow B

}
