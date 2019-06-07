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
        
    @CrossOrigin
    @PutMapping("/tagOnProduct")
    @ResponseBody
    public Tag setTagOnProduct(@RequestParam("idProduit") String idProduit, @RequestParam("tag") String tag) {
    	return tagBusiness.setTagOnProduct(tag, idProduit);
    }
    
    @CrossOrigin
    @GetMapping("/byProduct")
    @ResponseBody
    public List<Tag> getTagsByProduct(@RequestParam("idProduit") String idProduit) {
    	return tagBusiness.getAllTagByProduct(idProduit);
    }
    
    @CrossOrigin
    @PutMapping("/validateTag")
    @ResponseBody
    public Tag setTagStatusOK(@RequestParam("idTag") int idTag) throws NoResultException {
    	return tagService.setTagStatus(idTag, StatusEnum.OK);
    }
    
    @CrossOrigin
    @PutMapping("/refuseTag")
    @ResponseBody
    public Tag setTagStatusBlocked(@RequestParam("idTag") int idTag) throws NoResultException {
    	return tagService.setTagStatus(idTag, StatusEnum.BLOCKED);
    }

    @CrossOrigin
    @GetMapping("/toModerate")
    @ResponseBody
    public List<Tag> getTagsToModerate() {
    	return tagService.getAllTagsToModerate();
    }
}
