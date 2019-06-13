package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.ProduitRepository;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.ReferentielRequestException;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.util.HttpBookRequest;
import com.hicouch.back.core.util.HttpFilmRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hicouch.back.core.util.HttpGamesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    private HttpBookRequest httpBookRequest;
    private HttpFilmRequest httpFilmRequest;
    private HttpGamesRequest httpGamesRequest;

    private final ProduitRepository produitRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Override
	public List<ProductDTO> getProductsByKeyWordFromReferentiel(String keyword, String referentiel) throws BusinessException {
        List<ProductDTO> listProduct = new ArrayList<>();
        switch (referentiel) {
            case ProductTypeEnum.BOOK:
                listProduct = this.getBooksFromReferentiel(keyword);
                break;
            case ProductTypeEnum.SERIE:
            case ProductTypeEnum.MOVIE:
                listProduct =this.getFilmsByTitleFromReferentiel(keyword);
                break;
            case ProductTypeEnum.GAME:
                listProduct = this.getGamesByIdFromReferentiel(keyword);
                break;
            default:
			throw new BusinessException("No Referentiel Defined");
        }
        return listProduct;
    }

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
	 * 
	 * @throws BusinessException
	 * @throws Exception
	 */
	@Override
	public ProductDTO getProductByIdFromReferentiel(String productId, String referentiel) throws BusinessException {
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
			throw new BusinessException("No Referentiel Defined");
		}
		return result;
	}

}
