package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Signalement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalementRepository extends CrudRepository<Signalement,Integer> {
}
