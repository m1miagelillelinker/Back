package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/association" , produces = MediaType.APPLICATION_JSON_VALUE)
public class AssociationController {

    private final AssociationBusiness associationBusiness;
    private final AssociationService associationService;

    @Autowired
    public AssociationController(AssociationBusiness associationBusiness, AssociationService associationService) {
        this.associationBusiness = associationBusiness;
        this.associationService = associationService;
    }


    /**
     * Get associations of a product
     * @param idProduct
     * @return a list of associations
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/byProduct")
    @ResponseBody
    public List<AssociationDTO> getAssociationsByIdProduct(@RequestParam("idProduct")String idProduct) throws Exception {
        if(idProduct == null || idProduct.equals("")){
            throw new Exception();
        }
        return associationService.getAssociationsByIdProduct(idProduct);
    }

    /**
     * Get a list of recent associations
     * @return a list of associations
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/last")
    @ResponseBody
    public List<AssociationDTO> getTopLastAssociations() throws Exception {
        return associationService.getTopLastAssociations();
    }

    /**
     * Create an association between productA and productB
     * Return the existing associations if it already exists
     * @param idProductA id of product A
     * @param idfournA type of product A
     * @param idProductB id of product B
     * @param idfournB type of product B
     * @return the associations between product A and product B
     * @throws BusinessException
     */
    @CrossOrigin
    @PutMapping("/create")
    @ResponseBody
    public Association createAssociation(@RequestParam("idProductA") String idProductA, @RequestParam("idfournA") String idfournA, @RequestParam("idProductB") String idProductB, @RequestParam("idfournB") String idfournB) throws BusinessException {
        if(idProductA == null || idProductB == null || idProductA.equals("") || idProductB.equals("")){
            throw new BusinessException();
        }
        return associationBusiness.createOrGetAssociation(idProductA,idfournA, idProductB, idfournB);
    }

    /**
     * Create the giving associations
     * Return the existing associations if it already exists
     * @param asso the associations
     * @return the associations
     * @throws BusinessException
     */
    @CrossOrigin
    @PostMapping("/createasso")
    @ResponseBody
    public Association createAssociationPost(@RequestBody Association asso) throws BusinessException {
        if(asso.getIdproduitA() == null || asso.getIdproduitB() == null || asso.getIdfournA().equals("") || asso.getIdfournB().equals("") || asso.getIdUser()> 0 ){
            throw new BusinessException();
        }
        return associationBusiness.createOrGetAssociation(asso.getIdproduitA(),asso.getIdfournA(), asso.getIdproduitB(), asso.getIdfournB());
    }

    /**
     * Delete an associations
     * @param idAssociation the id of the association to delete
     * @return 
     * @throws Exception
     */
    @CrossOrigin
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteAssociation(@RequestParam("idAssociation") int idAssociation) throws Exception {
        return associationService.deleteAssociation(idAssociation);
    }

}
