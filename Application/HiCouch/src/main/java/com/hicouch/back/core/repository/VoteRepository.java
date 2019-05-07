package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Vote;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote,Integer> {

	Optional<List<Vote>> findAllByIdUser(int userId);

	Optional<List<Vote>> findAllByIdPair(int associationId);
	
	Optional<Vote> findOneByIdUserAndIdPair(int idUser, int idAsso);

}
