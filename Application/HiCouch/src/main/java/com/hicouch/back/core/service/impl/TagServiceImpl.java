package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.TagRepository;
import com.hicouch.back.core.service.TagService;
import com.hicouch.back.core.exception.NoResultException;
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
	public Tag getTagById(Integer id) throws NoResultException {
		return tagRepository.findById(id).orElseThrow(NoResultException::new);
	}
	
	@Override
	public List<Tag> getTagsByIds(List<Integer> ids) {
		return (List<Tag>) tagRepository.findAllById(ids);
	}

	@Override
	public Tag createOrGetTag(String tag) {
		Optional<Tag> existing = tagRepository.findOneByValue(tag);
		return existing.isPresent() ? existing.get() : tagRepository.save(new Tag(tag, 1, new Date(), new Date()));
	}

	@Override
	public List<Tag> getTagByValue(String tagValue) {
		return tagRepository.findAllByValue(tagValue);
	}

	@Override
	public Tag setTagStatus(int tagId, int status) throws NoResultException {
		Tag tag = tagRepository.findById(tagId).orElseThrow(NoResultException::new);
		tag.setStatus(status);
		return tagRepository.save(tag);
	}

}
