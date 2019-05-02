package myapp.repository;

import myapp.model.Abonnement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Integer> {

	Optional<List<Abonnement>> findAllByFollower(String userId);

	Optional<List<Abonnement>> findAllByFollows(String userId);
	
	Optional<Abonnement> findByFollowerAndFollows(Integer follower, Integer follows);

}
