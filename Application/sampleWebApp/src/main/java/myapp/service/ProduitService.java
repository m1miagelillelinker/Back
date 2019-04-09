package myapp.service;

public interface ProduitService {

    String getFilmByIdFromReferentiel(String filmId) throws Exception;

    String getFilmByTitleFromReferentiel(String title) throws Exception;

    String getBookByIdFromReferentiel(String bookId) throws Exception;

    String getGameByIdFromReferentiel(String gameId);
}
