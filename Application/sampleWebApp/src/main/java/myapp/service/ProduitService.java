package myapp.service;

import myapp.dto.ProductDTO;

public interface ProduitService {

    ProductDTO getFilmByIdFromReferentiel(String filmId) throws Exception;

    ProductDTO getFilmByTitleFromReferentiel(String title) throws Exception;

    ProductDTO getBookByIdFromReferentiel(String bookId) throws Exception;

    ProductDTO getGameByIdFromReferentiel(String gameId);
}
