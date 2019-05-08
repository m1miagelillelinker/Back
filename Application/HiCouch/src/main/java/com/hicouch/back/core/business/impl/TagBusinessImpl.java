package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.service.TagProduitService;
import com.hicouch.back.core.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagBusinessImpl implements TagBusiness {
	
	private TagService tagService;
	private TagProduitService tagProduitService;
	
	/**
	 * @param tagService
	 * @param tagProduitService
	 */
	@Autowired
	public TagBusinessImpl(TagService tagService, TagProduitService tagProduitService) {
		this.tagService = tagService;
		this.tagProduitService = tagProduitService;
	}

	@Override
	public void setTagOnProduct(String tag, String product) {
		Tag tagToSet = tagService.createOrGetTag(tag);
		tagProduitService.newTagProduit(tagToSet.getId(), product);
	}
}
