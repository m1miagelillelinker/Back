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
    @GetMapping("/getAssociationsByIdProduct")
    @ResponseBody
    public List<Association> getAssociationsByIdProduct(@RequestParam("id_association")String id_association) throws Exception {
        if(id_association == null || id_association.equals("")){
            throw new Exception();
        }
        return associationService.getAssociationsByIdProduct(id_association);
    }

    @CrossOrigin
    @PutMapping("/createAssociation")
    @ResponseBody
    public Association createAssociation(@RequestParam("id_association_1") String id_association_1, @RequestParam("id_association_2") String id_association_2) throws Exception {
        if(id_association_1 == null || id_association_2 == null || id_association_1.equals("") || id_association_2.equals("")){
            throw new Exception();
        }
        return associationService.createAssociation(id_association_1,id_association_2);
    }


    @CrossOrigin
    @DeleteMapping("/deleteAssociation")
    @ResponseBody
    public String deleteAssociation(@RequestParam("id_association") String id_association) throws Exception {
        if(id_association == null || id_association.equals("")){
            throw new Exception();
        }
        return associationService.deleteAssociation(id_association);
    }


}
