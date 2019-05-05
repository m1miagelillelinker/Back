package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.Tag;

public interface TagService {

	Tag getTagById(Integer id);
	
	Tag createTag(String tag);

	List<Tag> getTagsByIds(List<Integer> ids);

	Tag getTagByValue(String tagValue);
	
	/*
	 * TODO : 
	 * validation de tags
	 * suppression de tags
	 * 
	 */
	
	Tag setTagStatus(int tagId, int status);
}
