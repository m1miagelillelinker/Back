package myapp.service;

public interface ProduitService {

    String getFilmByIdFromReferentiel(String filmId);

    String getFilmByTitleFromReferentiel(String title);

    String getBookByIdFromReferentiel(String bookId);

    String getGameByIdFromReferentiel(String gameId);
}
