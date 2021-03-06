package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Abonnement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Integer> {

	List<Abonnement> findAllByFollower(int userId);

	List<Abonnement> findAllByFollows(int userId);
	
	Optional<Abonnement> findByFollowerAndFollows(Integer follower, Integer follows);

}
