package myapp.service.impl;

import myapp.model.Tag;
import myapp.repository.TagRepository;
import myapp.service.TagService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

	@Override
	public Tag getTagById(Integer id) {
		return tagRepository.findById(id).get();
	}

	@Override
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}

}
