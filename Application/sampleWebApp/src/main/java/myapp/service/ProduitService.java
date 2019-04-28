package myapp.service;

import myapp.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public interface ProduitService {

    ProductDTO getFilmByIdFromReferentiel(String filmId) throws Exception;

    ProductDTO getFilmByTitleFromReferentiel(String title) throws Exception;

    ProductDTO getBookByIdFromReferentiel(String bookId) throws Exception;

    ProductDTO getGameByIdFromReferentiel(String gameId);

    List<ProductDTO> getFilmsByTitleFromReferentiel(String research) throws Exception;
}
