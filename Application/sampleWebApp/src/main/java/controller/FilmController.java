package controller;

import business.FilmBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.FilmService;

@RestController
@RequestMapping(value = "/film" , produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmController {

    private final FilmBusiness filmBusiness;
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmBusiness filmBusiness, FilmService filmService){
        this.filmBusiness = filmBusiness;
        this.filmService = filmService;
    }

    @GetMapping("/getFilm/{filmID}")
    public String getFilmById5(@PathVariable String filmId){
        return filmService.getFilmById(filmId);
    }



}
