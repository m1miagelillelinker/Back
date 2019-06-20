package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.CommentaireBusiness;
import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.CommentaireFactory;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.service.CommentaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

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

    /**
     * Get a user's comments
     * @param userId the id of the users
     * @return a list of comment
     * @throws BusinessException
     */
    @CrossOrigin
    @GetMapping("/ByUserId")
    @ResponseBody
    public List<CommentaireDTO> getCommentaireByUserId(@RequestParam("userId") Integer userId) throws BusinessException {
        logger.trace("getCommentaireByUserId:"+userId);
        return commentaireFactory.convertCommentaires(commentaireService.findAllByIdUser(userId));
    }

    /**
     * Get an association comments
     * @param pairId the id of the pair of products
     * @return a list of comments
     * @throws BusinessException
     */
    @CrossOrigin
    @GetMapping("/ByAssoPairId")
    @ResponseBody
    public List<CommentaireDTO> getCommentaireByAssoPairId(@RequestParam("pairId") Integer pairId) throws BusinessException {
        logger.trace("getCommentaireByAssoPairId:"+pairId);
        return commentaireFactory.convertCommentaires(commentaireService.getCommentaireByAsso(pairId));
    }

    /**
     * Create a comment
     * @param comm the comment to create 
     * @return the created comment
     * @throws BusinessException
     */
    @CrossOrigin
    @PutMapping("/new")
    @ResponseBody
    public Commentaire addCommentaire(@RequestBody Commentaire comm) throws BusinessException {
        logger.trace("addCommentaire:"+comm);
        if( comm == null ){
            throw new InvalidParameterException();
        }
        return commentaireBusiness.addCommentaire(comm);
    }

    /**
     * Hide a comment
     * @param comm the comment to hide
     * @return the comment
     * @throws BusinessException
     */
    @CrossOrigin
    @PutMapping("/hide")
    @ResponseBody
    public Commentaire hideCommentaire(@RequestBody Commentaire comm) throws BusinessException {
        logger.trace("hideCommentaire:"+comm);
        if(comm == null ){
        	throw new InvalidParameterException();
        }
        return commentaireService.hideCommentaire(comm);
    }

    /**
     * Update a comment
     * @param comm the comment to update
     * @return the comment
     * @throws NoResultException
     */
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
