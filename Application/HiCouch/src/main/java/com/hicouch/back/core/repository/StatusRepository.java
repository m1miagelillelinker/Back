package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status,Integer> {
}
