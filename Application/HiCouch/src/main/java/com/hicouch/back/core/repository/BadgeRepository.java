package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends CrudRepository<Badge,Integer> {

    List<Badge> findAll();
}
