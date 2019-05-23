package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.CommentaireService;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping("/ByUserId/{userId}")
    @ResponseBody
    public List<Commentaire> getCommentaireByUserId(@RequestParam("userId") Integer userId) throws Exception {
        //TODO
        return commentaireService.findAllByIdUser(userId);
    }

    @CrossOrigin
    @GetMapping("/ByAssoPairId/{assoId}")
    @ResponseBody
    public List<Commentaire> getCommentaireByAssoPairId(@RequestParam("assoId") Integer assoId) throws Exception {
        //TODO
        return commentaireService.getCommentaireByAsso(assoId);
    }

    @CrossOrigin
    @GetMapping("/new/{idAsso}")
    @ResponseBody
    public String addCommentaire(@RequestBody Commentaire comm) throws Exception {
        if( comm != null ){
            return commentaireService.addCommentaire(comm);
        }else{
            throw new InvalidParameterException();
        }
    }

    @CrossOrigin
    @GetMapping("/hide/")
    @ResponseBody
    public String hideCommentaire(@RequestBody Commentaire comm) throws Exception {
        if(comm != null ){
            return commentaireService.hideCommentaire(comm);
        }else{
            throw new InvalidParameterException();
        }
    }

    @CrossOrigin
    @PostMapping("/updateCommentaire")
    @ResponseBody
    public Commentaire updateCommentaire(@RequestBody Commentaire json) throws NoResultException {
        if(json != null && !json.equals("")){
            return commentaireService.updateCommentaire(json);
        }else{
            throw new InvalidParameterException();
        }
    }



}
