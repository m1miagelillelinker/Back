package myapp.service.impl;


import myapp.repository.ProduitRepository;
import myapp.service.ProduitService;
import myapp.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements ProduitService {

    private HttpRequest httpRequestJeux;
    private HttpRequest httpRequestFilm;
    private HttpRequest httpRequestSerie;
    private HttpRequest httpRequestLivres;

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public String getFilmByIdFromReferentiel(String filmId) {
        try{
            httpRequestFilm = new HttpRequest("http://www.omdbapi.com/?i="+filmId+"&apikey=9b0bebec");
            String s = httpRequestFilm.request("GET");
            System.out.println(s);
            return s;
        }catch(Exception e){
            e.printStackTrace();
            return null; //a changer
        }
    }

    @Override
    public String getFilmByTitleFromReferentiel(String title) {
        try{
            httpRequestFilm = new HttpRequest("http://www.omdbapi.com/?t="+title+"&apikey=9b0bebec");
            String s = httpRequestFilm.request("GET");
            System.out.println(s);
            return s;
        }catch(Exception e){
            e.printStackTrace();
            return null; //a changer
        }
    }

    @Override
    public String getBookByIdFromReferentiel(String bookId) {
        try{
            httpRequestFilm = new HttpRequest("https://www.googleapis.com/books/v1/volumes?q=isbn:"+bookId);
            String s = httpRequestFilm.request("GET");
            System.out.println(s);
            return s;
        }catch(Exception e){
            e.printStackTrace();
            return null; //a changer
        }
    }

    @Override
    public String getGameByIdFromReferentiel(String gameId) {
        return null;
    }


}
