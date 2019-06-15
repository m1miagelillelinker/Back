package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.CommentaireFactory;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.CommentaireService;

import java.security.InvalidParameterException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/commentaire" , produces = MediaType.APPLICATION_JSON_VALUE )
public class CommentaireController {

    private final CommentaireBusiness commentaireBusiness;
    private final CommentaireService commentaireService;
    private final CommentaireFactory commentaireFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CommentaireController(CommentaireBusiness commentaireBusiness, CommentaireService commentaireService,CommentaireFactory commentaireFactory) {
        this.commentaireBusiness = commentaireBusiness;
        this.commentaireService  = commentaireService;
        this.commentaireFactory  = commentaireFactory;
    }

    @CrossOrigin
    @GetMapping("/ByUserId")
    @ResponseBody
    public List<CommentaireDTO> getCommentaireByUserId(@RequestParam("userId") Integer userId) throws Exception {
        logger.trace("getCommentaireByUserId:"+userId);
        return commentaireFactory.convertCommentaires(commentaireService.findAllByIdUser(userId));
    }

    @CrossOrigin
    @GetMapping("/ByAssoPairId")
    @ResponseBody
    public List<CommentaireDTO> getCommentaireByAssoPairId(@RequestParam("pairId") Integer pairId) throws Exception {
        logger.trace("getCommentaireByAssoPairId:"+pairId);
        return commentaireFactory.convertCommentaires(commentaireService.getCommentaireByAsso(pairId));
    }

    @CrossOrigin
    @PutMapping("/new")
    @ResponseBody
    public Commentaire addCommentaire(@RequestBody Commentaire comm) throws Exception {
        logger.trace("addCommentaire:"+comm);
        if( comm == null ){
            throw new InvalidParameterException();
        }
        return commentaireBusiness.addCommentaire(comm);
    }

    @CrossOrigin
    @PutMapping("/hide")
    @ResponseBody
    public Commentaire hideCommentaire(@RequestBody Commentaire comm) throws Exception {
        logger.trace("hideCommentaire:"+comm);
        if(comm == null ){
        	throw new InvalidParameterException();
        }
        return commentaireService.hideCommentaire(comm);
    }

    @CrossOrigin
    @PutMapping("/update")
    @ResponseBody
    public Commentaire updateCommentaire(@RequestBody Commentaire comm) throws NoResultException {
        logger.trace("hideCommentaire:"+comm);
        if(comm == null){
            throw new InvalidParameterException();
        }
        return commentaireService.updateCommentaire(comm);
    }



}
