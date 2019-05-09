package com.hicouch.back.core.service.impl;


import com.hicouch.back.core.repository.ProduitRepository;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.util.HttpBookRequest;
import com.hicouch.back.core.util.HttpFilmRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    private HttpBookRequest httpBookRequest;
    private HttpFilmRequest httpFilmRequest;

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public ProductDTO getFilmByIdFromReferentiel(String filmId) throws Exception {
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?i="+filmId+"&apikey=9b0bebec");
            return httpFilmRequest.request("GET");
        }catch(Exception e){
            throw new Exception();
        }
    }

    @Override
    public ProductDTO getFilmByTitleFromReferentiel(String title) throws Exception{
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?t="+title+"&apikey=9b0bebec");
            return httpFilmRequest.request("GET");
        }catch(Exception e){
            throw new Exception();
        }
    }

    @Override
    public ProductDTO getBookByIdFromReferentiel(String bookId) throws Exception {
        try{
            httpBookRequest = new HttpBookRequest("https://www.googleapis.com/books/v1/volumes?q=isbn:"+bookId);
            return httpBookRequest.request("GET");
        }catch(Exception e){
            throw new Exception();
        }
    }

    // TODO : REQUEST L'API JEU VIDEO
    @Override
    public ProductDTO getGameByIdFromReferentiel(String gameId) {
        return null;
    }

    @Override
    public List<ProductDTO> getFilmsByTitleFromReferentiel(String research) throws Exception {
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?s="+research+"&apikey=9b0bebec");
            return httpFilmRequest.requestMultiple("GET");

        }catch(Exception e){
            throw new Exception();
        }
    }


    /**
     * TODO : refacto
     * @throws Exception 
     */
	@Override
	public ProductDTO getProductByIdFromReferentiel(String productId, String referentiel) throws Exception {
		// TODO Auto-generated method stub
		ProductDTO result = null;
		switch(referentiel) {
		case "film":
			result = getFilmByIdFromReferentiel(productId);
			break;
		case "book":
			result = getBookByIdFromReferentiel(productId);
			break;
		case "serie":
			break;
		case "game":
			break;
		default:
			break;
			
		}
		return result;
	}


}
