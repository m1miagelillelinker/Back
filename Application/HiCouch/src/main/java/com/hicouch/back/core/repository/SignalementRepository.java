package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Signalement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalementRepository extends CrudRepository<Signalement,Integer> {
	
	List<Signalement> findAllByStatus(int status);
	List<Signalement> findAllByStatusAndTypeSignalement(int status, String type);
}
