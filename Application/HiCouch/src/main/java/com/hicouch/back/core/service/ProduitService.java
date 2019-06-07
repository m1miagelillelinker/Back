package com.hicouch.back.core.service;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.exception.ReferentielRequestException;

import java.util.List;

public interface ProduitService {

    ProductDTO getFilmByIdFromReferentiel(String filmId) throws ReferentielRequestException;

    ProductDTO getFilmByTitleFromReferentiel(String title) throws ReferentielRequestException;

    ProductDTO getBookByIdFromReferentiel(String bookId) throws ReferentielRequestException;

    ProductDTO getGameByIdFromReferentiel(String gameId) throws ReferentielRequestException;
    
    ProductDTO getProductByIdFromReferentiel(String productId, String referentiel) throws Exception;

    List<ProductDTO> getFilmsByTitleFromReferentiel(String research) throws ReferentielRequestException;

    List<ProductDTO> getGamesByIdFromReferentiel(String keyword) throws ReferentielRequestException;

    List<ProductDTO> getBooksFromReferentiel(String keyword) throws  ReferentielRequestException;

    List<ProductDTO> getProductsByKeyWordFromReferentiel(String keyword, String referentiel) throws Exception;
}
