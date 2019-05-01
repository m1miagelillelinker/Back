package myapp.repository;

import myapp.model.Commentaire;
import myapp.model.Signalement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalementRepository extends CrudRepository<Signalement,Integer> {
}
