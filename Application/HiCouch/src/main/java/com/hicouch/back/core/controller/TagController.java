package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void setTagOnProduct(@RequestParam("idProduit") String idProduit, @RequestParam("tag") String tag) {
    	tagBusiness.setTagOnProduct(tag, idProduit);
    }
    
    @CrossOrigin
    @PutMapping("/validateTag")
    public Tag setTagStatusOK(@RequestParam("idTad") int idTag) {
    	return tagService.setTagStatus(idTag, StatusEnum.OK);
    }
    
    @CrossOrigin
    @PutMapping("/refuseTag")
    public Tag setTagStatusBlocked(@RequestParam("idTad") int idTag) {
    	return tagService.setTagStatus(idTag, StatusEnum.BLOCKED);
    }

}
