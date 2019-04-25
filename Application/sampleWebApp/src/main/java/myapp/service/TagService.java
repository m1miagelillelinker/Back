package myapp.service;

import java.util.List;

import myapp.model.Tag;

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
}
