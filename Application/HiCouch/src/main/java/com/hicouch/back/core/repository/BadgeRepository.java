package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends CrudRepository<Badge,Integer> {
}
