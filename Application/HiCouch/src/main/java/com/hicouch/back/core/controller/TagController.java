package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.service.TagService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/tag" , produces = MediaType.APPLICATION_JSON_VALUE )
public class TagController {

	private final TagBusiness tagBusiness;
    private final TagService tagService;

    @Autowired
    public TagController(TagBusiness tagBusiness, TagService tagService) {
        this.tagBusiness = tagBusiness;
        this.tagService = tagService;
    }
    
    /**
     * Add a tag on a product
     * Create the tag if it does not exists
     * @param idProduit the id of the product
     * @param tag the value of the tag
     * @return the tag
     */
    @CrossOrigin
    @PutMapping("/tagOnProduct")
    @ResponseBody
    public Tag setTagOnProduct(@RequestParam("idProduit") String idProduit, @RequestParam("tag") String tag) {
    	return tagBusiness.setTagOnProduct(tag, idProduit);
    }
    
    /**
     * Get tags on a product
     * @param idProduit the id of the product
     * @return a list of tags
     */
    @CrossOrigin
    @GetMapping("/byProduct")
    @ResponseBody
    public List<Tag> getTagsByProduct(@RequestParam("idProduit") String idProduit) {
    	return tagBusiness.getAllTagByProduct(idProduit);
    }
    
    /**
     * Accept a tag
     * @param idTag the id of the tag
     * @return the tag
     * @throws NoResultException
     */
    @CrossOrigin
    @PutMapping("/validateTag")
    @ResponseBody
    public Tag setTagStatusOK(@RequestParam("idTag") int idTag) throws NoResultException {
    	return tagService.setTagStatus(idTag, StatusEnum.OK);
    }
    
    /**
     * Refuse a tag
     * @param idTag the id of the tag
     * @return the tag
     * @throws NoResultException
     */
    @CrossOrigin
    @PutMapping("/refuseTag")
    @ResponseBody
    public Tag setTagStatusBlocked(@RequestParam("idTag") int idTag) throws NoResultException {
    	return tagService.setTagStatus(idTag, StatusEnum.BLOCKED);
    }

    /**
     * Get tags waiting for validation
     * @return a list of tags
     */
    @CrossOrigin
    @GetMapping("/toModerate")
    @ResponseBody
    public List<Tag> getTagsToModerate() {
    	return tagService.getAllTagsToModerate();
    }
}
