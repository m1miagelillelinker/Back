package myapp.controller;

import myapp.business.ProduitBusiness;
import myapp.business.UserBusiness;
import myapp.dto.ProductDTO;
import myapp.model.Produit;
import myapp.model.User;
import myapp.service.ProduitService;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product" , produces = MediaType.APPLICATION_JSON_VALUE )
public class ProduitController {

    private final ProduitService produitService;
    private final ProduitBusiness produitBusiness;


    @Autowired
    public ProduitController(ProduitService produitService, ProduitBusiness productBusiness) {
        this.produitBusiness = productBusiness;
        this.produitService = produitService;
    }


    @CrossOrigin
    @GetMapping("/getFilmByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getFilmByIdFromReferentiel(@RequestParam("filmId") String filmId) throws Exception {
        if(filmId == null || filmId.equals("")){
            throw new Exception();
        }
        return produitService.getFilmByIdFromReferentiel(filmId);
    }

    @CrossOrigin
    @GetMapping("/getFilmsByTitleFromReferentiel")
    @ResponseBody
    public List<ProductDTO> getFilmsByTitleFromReferentiel(@RequestParam("research") String research) throws Exception {
        if(research == null || research.equals("")){
            throw new Exception();
        }
        return produitService.getFilmsByTitleFromReferentiel(research);
    }


    @CrossOrigin
    @GetMapping("/getFilmByTitleFromReferentiel")
    @ResponseBody
    public ProductDTO getFilmByTitleFromReferentiel(@RequestParam("title")String title) throws Exception {
        if(title == null || title.equals("")){
            throw new Exception();
        }
        return produitService.getFilmByTitleFromReferentiel(title);
    }

    @CrossOrigin
    @GetMapping("/getBookByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getBookByIdFromReferentiel(@RequestParam("bookId")String bookId) throws Exception {
        if(bookId == null || bookId.equals("")){
            throw new Exception();
        }
        return produitService.getBookByIdFromReferentiel(bookId);
    }

    @CrossOrigin
    @GetMapping("/getGameByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getGameByIdFromReferentiel(@RequestParam("gameId")String gameId) throws Exception {
        if(gameId == null || gameId.equals("")){
            throw new Exception();
        }
        return produitService.getGameByIdFromReferentiel(gameId);
    }

}
