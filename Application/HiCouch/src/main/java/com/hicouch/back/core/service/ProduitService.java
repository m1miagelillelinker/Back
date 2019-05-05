package com.hicouch.back.core.service;

import com.hicouch.back.core.dto.ProductDTO;

import java.util.List;

public interface ProduitService {

    ProductDTO getFilmByIdFromReferentiel(String filmId) throws Exception;

    ProductDTO getFilmByTitleFromReferentiel(String title) throws Exception;

    ProductDTO getBookByIdFromReferentiel(String bookId) throws Exception;

    ProductDTO getGameByIdFromReferentiel(String gameId);

    List<ProductDTO> getFilmsByTitleFromReferentiel(String research) throws Exception;
}
