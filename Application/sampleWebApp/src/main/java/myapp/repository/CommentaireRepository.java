package myapp.repository;

import myapp.model.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Integer> {
}
