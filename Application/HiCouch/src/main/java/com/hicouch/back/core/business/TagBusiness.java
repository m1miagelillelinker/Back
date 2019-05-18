package com.hicouch.back.core.business;

import java.util.List;

import com.hicouch.back.core.model.Tag;

public interface TagBusiness {
	
	Tag setTagOnProduct(String tag, String product);
	
	List<Tag> getAllTagByProduct(String idProduct);
}
