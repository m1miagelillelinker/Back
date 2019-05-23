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
    private final static Logger logger = LoggerFactory.getLogger(CommentaireController.class);

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
    public List<Commentaire> getCommentaireByAssoPairId(@RequestParam("assoId") Integer assoId) throws Exception {
        logger.trace("getCommentaireByAssoPairId:"+assoId);
        return commentaireService.getCommentaireByAsso(assoId);
    }

    @CrossOrigin
    @PostMapping("/new/{idAsso}")
    @ResponseBody
    public String addCommentaire(@RequestBody Commentaire comm) throws Exception {
        logger.trace("addCommentaire:"+comm);
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
        logger.trace("hideCommentaire:"+comm);
        if(comm != null ){
            return commentaireService.hideCommentaire(comm);
        }else{
            throw new InvalidParameterException();
        }
    }

    @CrossOrigin
    @PostMapping("/updateCommentaire")
    @ResponseBody
    public Commentaire updateCommentaire(@RequestBody Commentaire comm) throws NoResultException {
        logger.trace("hideCommentaire:"+comm);
        if(comm != null && !comm.equals("")){
            return commentaireService.updateCommentaire(comm);
        }else{
            throw new InvalidParameterException();
        }
    }



}
