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
    @GetMapping("/getAssociationById")
    @ResponseBody
    public Association getAssociation (@RequestParam("id_association")String id_association) throws Exception {
        if(id_association == null || id_association.equals("")){
            throw new Exception();
        }
        return associationService.getAssociationById(id_association);
    }

    @CrossOrigin
    @PostMapping("/createAssociation")
    @ResponseBody
    public Association createAssociation () throws Exception {
        return null;
    }

    @CrossOrigin
    @PostMapping("/getAssociatedProducts")
    @ResponseBody
    public List<Produit> getAssociatedProducts(@RequestParam("id_product") String id_product) throws Exception{
        if(id_product == null || id_product.equals("")){
            throw new Exception();
        }

        return associationBusiness.findAllAssociateProduct(id_product);

    }







}
