package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.TagRepository;
import com.hicouch.back.core.service.TagService;
import com.hicouch.back.core.model.Tag;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

	@Override
	public Tag getTagById(Integer id) {
		return tagRepository.findById(id).get();
	}
	
	@Override
	public List<Tag> getTagsByIds(List<Integer> ids) {
		return (List<Tag>) tagRepository.findAllById(ids);
	}

	@Override
	public Tag createTag(String tag) {
		Tag result;
		Optional<Tag> existing = tagRepository.findOneByValue(tag);
		
		if(existing.isPresent()) {
			result = existing.get();
		} else {
			result = tagRepository.save(new Tag(tag, 1, new Date(), new Date()));
		}
		
		return result;
	}

	@Override
	public Tag getTagByValue(String tagValue) {
		return tagRepository.findAllByValue(tagValue);
	}

	@Override
	public Tag setTagStatus(int tagId, int status) {
		// TODO Auto-generated method stub
		Optional<Tag> tagFound = tagRepository.findById(tagId);
		Tag tag = null;
		if(tagFound.isPresent()) {
			tag = tagFound.get();
			tag.setStatus(status);
		}
		return tag;
	}

}
