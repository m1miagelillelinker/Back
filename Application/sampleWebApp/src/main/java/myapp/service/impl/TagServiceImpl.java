package myapp.service.impl;

import myapp.model.Tag;
import myapp.repository.TagRepository;
import myapp.service.TagService;
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
			result = tagRepository.save(new Tag(tag, 0, new Date(), new Date()));
		}
		
		return result;
	}

	@Override
	public Tag getTagByValue(String tagValue) {
		return tagRepository.findAllByValue(tagValue);
	}

}
