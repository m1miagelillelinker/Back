package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Tag;

public interface TagService {

	Tag getTagById(Integer id) throws NoResultException;
	
	Tag createOrGetTag(String tag);

	List<Tag> getTagsByIds(List<Integer> ids);

	List<Tag> getTagByValue(String tagValue);
	
	Tag setTagStatus(int tagId, int status) throws NoResultException;
}
