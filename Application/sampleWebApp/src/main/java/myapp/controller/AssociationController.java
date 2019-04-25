package myapp.controller;

import myapp.business.AssociationBusiness;
import myapp.model.Association;
import myapp.model.Produit;
import myapp.service.AssociationService;
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
    public Association createAssociation() throws Exception {
        return null;
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
