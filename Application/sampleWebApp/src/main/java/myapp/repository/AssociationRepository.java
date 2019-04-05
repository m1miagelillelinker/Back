package myapp.repository;

import myapp.model.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends CrudRepository<Association,Integer> {
}
