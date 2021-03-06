package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {

	Optional<Tag> findOneByValue(String tag);

	List<Tag> findAllByValue(String tagValue);
	
	List<Tag> findAllByStatus(int status);
	
}
