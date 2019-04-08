package myapp.service;

import myapp.model.Tag;

public interface TagService {

	Tag getTagById(Integer id);
	
	Tag createTag(Tag tag);
	
	/*
	 * TODO : 
	 * validation de tags
	 * suppression de tags
	 * 
	 */
}
