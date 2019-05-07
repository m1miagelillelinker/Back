package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/association" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AssociationController {

    private final AssociationBusiness associationBusiness;
    private final AssociationService associationService;

    @Autowired
    public AssociationController(AssociationBusiness associationBusiness, AssociationService associationService) {
        this.associationBusiness = associationBusiness;
        this.associationService = associationService;
    }


    @CrossOrigin
    @GetMapping("/byProduct")
    @ResponseBody
    public List<Association> getAssociationsByIdProduct(@RequestParam("idProduct")String idProduct) throws Exception {
        if(idProduct == null || idProduct.equals("")){
            throw new Exception();
        }
        return associationService.getAssociationsByIdProduct(idProduct);
    }

    @CrossOrigin
    @PutMapping("/create")
    @ResponseBody
    public Association createAssociation(@RequestParam("idProductA") String idProductA, @RequestParam("idProductB") String idProductB) throws Exception {
        if(idProductA == null || idProductB == null || idProductA.equals("") || idProductB.equals("")){
            throw new Exception();
        }
        return associationService.createAssociation(idProductA,idProductB);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteAssociation(@RequestParam("idAssociation") int idAssociation) throws Exception {
        return associationService.deleteAssociation(idAssociation);
    }


}