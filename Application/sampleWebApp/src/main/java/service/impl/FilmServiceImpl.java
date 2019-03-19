package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FilmRepository;
import service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public String getFilmById(String filmId) {
        //filmRepository.findById(filmId).. en gros.
        //return "Coucou je suis un super film";
        return "{oui:non}";
    }
}
