package myapp.repository;

import myapp.model.Vote;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote,Integer> {

	Optional<List<Vote>> findAllByIdUser(String userId);

	Optional<List<Vote>> findAllByIdAssoc(String associationId);

}
