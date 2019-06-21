package com.hicouch.back.core.service;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Tag;

import java.util.List;

public interface TagService {

	Tag getTagById(Integer id) throws NoResultException;
	
	Tag createOrGetTag(String tag);

	List<Tag> getTagsByIds(List<Integer> ids);

	List<Tag> getTagByValue(String tagValue);
	
	Tag setTagStatus(int tagId, int status) throws NoResultException;
	
	Tag getTagByIdOrNull(Integer id);
	
	List<Tag> getAllTagsToModerate();
}
