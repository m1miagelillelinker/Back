package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get a film or a serie
     * @param filmId the id of the film or serie
     * @return a productDTO containing the film or serie
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getFilmByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getFilmByIdFromReferentiel(@RequestParam("filmId") String filmId) throws Exception {
        if(filmId == null || filmId.equals("")){
            throw new Exception();
        }
        return produitBusiness.getCompleteProduct(filmId, ProductTypeEnum.MOVIE);
    }

    /**
     * Search a film or serie
     * @param research the keywords to search
     * @return a list of productDTO containing the films or series
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getFilmsByTitleFromReferentiel")
    @ResponseBody
    public List<ProductDTO> getFilmsByTitleFromReferentiel(@RequestParam("research") String research) throws Exception {
        if(research == null || research.equals("")){
            throw new Exception();
        }
        return produitBusiness.getCompleteProducts(research,ProductTypeEnum.MOVIE);
    }

    /**
     * Get a book
     * @param bookId the id of the book
     * @return a productDTO containing the book
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getBookByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getBookByIdFromReferentiel(@RequestParam("bookId")String bookId) throws Exception {
        if(bookId == null || bookId.equals("")){
            throw new Exception();
        }
        return produitBusiness.getCompleteProduct(bookId, ProductTypeEnum.BOOK);
    }

    /**
     * Search a book
     * @param keyword the keywords to search
     * @return a list of productDTO containing the books
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getBooksFromReferentiel")
    @ResponseBody
    public List<ProductDTO> getBooksFromReferentiel(@RequestParam("keyword")String keyword) throws Exception{
        if(keyword == null || keyword.equals("")){
            throw new Exception();
        }
        return produitBusiness.getCompleteProducts(keyword,ProductTypeEnum.BOOK);
    }

    /**
     * Get a game
     * @param gameId the id of the game
     * @return a productDTO containing the game
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getGameByIdFromReferentiel")
    @ResponseBody
    public ProductDTO getGameByIdFromReferentiel(@RequestParam("gameId")String gameId) throws Exception {
        if(gameId == null || gameId.equals("")){
            throw new Exception();
        }
        return produitBusiness.getCompleteProduct(gameId, ProductTypeEnum.GAME);
    }

    /**
     * Search a game
     * @param keyword the keywords to search
     * @return a list of productDTO containing the games
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/getGamesByReferentiel")
    @ResponseBody
    public List<ProductDTO> getGamesByReferentiel(@RequestParam("keyword")String keyword) throws Exception{
        if(keyword == null || keyword.equals("")){
            throw new Exception();
        }

        return produitBusiness.getCompleteProducts(keyword,ProductTypeEnum.GAME);
    }

}
