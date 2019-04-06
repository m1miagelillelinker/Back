package myapp.controller;

import myapp.business.ProduitBusiness;
import myapp.business.UserBusiness;
import myapp.model.Produit;
import myapp.model.User;
import myapp.service.ProduitService;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/product" , produces = MediaType.APPLICATION_JSON_VALUE )
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private ProduitBusiness produitBusiness;

    @CrossOrigin
    @GetMapping("/getFilmByIdFromReferentiel")
    @ResponseBody
    public String getFilmByIdFromReferentiel(@RequestParam("filmId") String filmId){
        return produitService.getFilmByIdFromReferentiel(filmId);
    }

    @CrossOrigin
    @GetMapping("/getFilmByTitleFromReferentiel")
    @ResponseBody
    public String getFilmByTitleFromReferentiel(@RequestParam("title")String title){
        return produitService.getFilmByTitleFromReferentiel(title);
    }

    @CrossOrigin
    @GetMapping("/getBookByIdFromReferentiel")
    @ResponseBody
    public String getBookByIdFromReferentiel(@RequestParam("bookId")String bookId){
        return produitService.getBookByIdFromReferentiel(bookId);
    }

    @CrossOrigin
    @GetMapping("/getGameByIdFromReferentiel")
    @ResponseBody
    public String getGameByIdFromReferentiel(@RequestParam("gameId")String gameId){
        return produitService.getGameByIdFromReferentiel(gameId);
    }

}
