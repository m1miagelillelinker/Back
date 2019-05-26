package com.hicouch.back.core.service.impl;


import com.hicouch.back.core.repository.ProduitRepository;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.exception.ReferentielRequestException;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.util.HttpBookRequest;
import com.hicouch.back.core.util.HttpFilmRequest;
import com.hicouch.back.core.util.HttpGamesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    private HttpBookRequest httpBookRequest;
    private HttpFilmRequest httpFilmRequest;
    private HttpGamesRequest httpGamesRequest;

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public ProductDTO getFilmByIdFromReferentiel(String filmId) throws ReferentielRequestException {
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?i="+filmId+"&apikey=9b0bebec");
            return httpFilmRequest.request("GET");
        }catch(Exception e){
            throw new ReferentielRequestException("idProduit : " + filmId);
        }
    }

    @Override
    public ProductDTO getFilmByTitleFromReferentiel(String title) throws ReferentielRequestException{
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?t="+title+"&apikey=9b0bebec");
            return httpFilmRequest.request("GET");
        }catch(Exception e){
            throw new ReferentielRequestException("title : " + title);
        }
    }

    @Override
    public ProductDTO getBookByIdFromReferentiel(String bookId) throws ReferentielRequestException {
        try{
            httpBookRequest = new HttpBookRequest("https://www.googleapis.com/books/v1/volumes?q=isbn:"+bookId);
            return httpBookRequest.request("GET");
        }catch(Exception e){
            throw new ReferentielRequestException("idProduit : " + bookId);
        }
    }

    @Override
    public List<ProductDTO> getBooksFromReferentiel(String keyword) throws ReferentielRequestException {
        try{
            httpBookRequest = new HttpBookRequest("https://www.googleapis.com/books/v1/volumes?q="+keyword);
            return httpBookRequest.requestMultiple("GET");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReferentielRequestException();
        }
    }

    // TODO : REQUEST L'API JEU VIDEO
    @Override
    public ProductDTO getGameByIdFromReferentiel(String gameId) throws ReferentielRequestException {
        try{
            httpGamesRequest = new HttpGamesRequest();
            return httpGamesRequest.request(gameId);
        }catch (Exception e){
            throw new ReferentielRequestException();
        }
    }

    public List<ProductDTO> getGamesByIdFromReferentiel(String keyword) throws ReferentielRequestException{
        try{
            httpGamesRequest = new HttpGamesRequest();
            return httpGamesRequest.requestMultiple(keyword);
        }catch (Exception e){
            throw new ReferentielRequestException();
        }
    }

    @Override
    public List<ProductDTO> getFilmsByTitleFromReferentiel(String research) throws ReferentielRequestException {
        try{
            httpFilmRequest = new HttpFilmRequest("http://www.omdbapi.com/?s="+research+"&apikey=9b0bebec");
            return httpFilmRequest.requestMultiple("GET");

        }catch(Exception e){
            throw new ReferentielRequestException();
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
		switch (referentiel) {
		case ProductTypeEnum.BOOK:
			result = this.getBookByIdFromReferentiel(productId);
			break;
		case ProductTypeEnum.SERIE:
		case ProductTypeEnum.MOVIE:
			result = this.getFilmByIdFromReferentiel(productId);
			break;
		case ProductTypeEnum.GAME:
		    result = this.getGameByIdFromReferentiel(productId);
		    break;
		default:
			throw new Exception("No Referentiel Defined");
		}
		return result;
	}


}
