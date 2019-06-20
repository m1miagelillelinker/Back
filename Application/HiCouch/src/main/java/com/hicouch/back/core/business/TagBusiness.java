package com.hicouch.back.core.business;

import com.hicouch.back.core.model.Tag;

import java.util.List;

public interface TagBusiness {
	
	Tag setTagOnProduct(String tag, String product);
	
	List<Tag> getAllTagByProduct(String idProduct);
}
