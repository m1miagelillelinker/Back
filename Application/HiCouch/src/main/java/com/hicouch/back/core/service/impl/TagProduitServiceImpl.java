package com.hicouch.back.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hicouch.back.core.model.TagProduit;
import com.hicouch.back.core.repository.TagProduitRepository;
import com.hicouch.back.core.service.TagProduitService;

@Service
public class TagProduitServiceImpl implements TagProduitService {
	
	private TagProduitRepository tagProduitRepository;
	
	/**
	 * @param tagProduitRepository
	 */
	@Autowired
	public TagProduitServiceImpl(TagProduitRepository tagProduitRepository) {
		this.tagProduitRepository = tagProduitRepository;
	}

	@Override
	public TagProduit newTagProduit(int idTag, String idProduit) {
		TagProduit tagProduit = new TagProduit(idProduit, idTag, new Date(), new Date());
		return tagProduitRepository.save(tagProduit);
	}

	@Override
	public List<TagProduit> findAllTagProduitByIdProduit(String idProduit) {
		return tagProduitRepository.findAllByIdProduit(idProduit);
	}

}
