package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Abonnement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Integer> {

	Optional<List<Abonnement>> findAllByFollower(int userId);

	Optional<List<Abonnement>> findAllByFollows(int userId);
	
	Optional<Abonnement> findByFollowerAndFollows(Integer follower, Integer follows);

}
