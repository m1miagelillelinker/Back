package com.hicouch.back.core.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
	public TagProduit createOrGetTagProduit(int idTag, String idProduit) {
		Optional<TagProduit> oldTagProduit = tagProduitRepository.findByIdProduitAndIdTag(idProduit, idTag);
		TagProduit tagProduit = oldTagProduit.isPresent() 
				? tagProduit = oldTagProduit.get() 
				: new TagProduit(idProduit, idTag, LocalDateTime.now(), LocalDateTime.now());
		return tagProduitRepository.save(tagProduit);
	}

	@Override
	public List<TagProduit> findAllTagProduitByIdProduit(String idProduit) {
		return tagProduitRepository.findAllByIdProduit(idProduit);
	}

}
