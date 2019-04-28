package myapp.repository;

import myapp.model.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepository extends CrudRepository<Association,Integer> {
    void deleteById(String id);

    List<Association>  findAllByidproduitA(String id);
}
