package myapp.controller;

import myapp.business.CommentaireBusiness;
import myapp.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/commentaire" , produces = MediaType.APPLICATION_JSON_VALUE )
public class CommentaireController {

    private final CommentaireBusiness commentaireBusiness;
    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireBusiness commentaireBusiness, CommentaireService commentaireService) {
        this.commentaireBusiness = commentaireBusiness;
        this.commentaireService = commentaireService;
    }
}
