package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Tag;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {

	Optional<Tag> findOneByValue(String tag);

	Tag findAllByValue(String tagValue);
	
}
