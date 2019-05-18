package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.model.TagProduit;
import com.hicouch.back.core.service.TagProduitService;
import com.hicouch.back.core.service.TagService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
	public Tag setTagOnProduct(String tag, String product) {
		Tag tagToSet = tagService.createOrGetTag(tag);
		tagProduitService.createOrGetTagProduit(tagToSet.getId(), product);
		return tagToSet;
	}

	@Override
	public List<Tag> getAllTagByProduct(String idProduct) {
		return tagProduitService.findAllTagProduitByIdProduit(idProduct)
				.stream()
				.map((TagProduit tp) -> tp.getIdTag())
				.map((Integer i) -> tagService.getTagByIdOrNull(i))
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
}
