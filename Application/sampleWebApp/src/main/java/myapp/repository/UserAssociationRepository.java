package myapp.repository;

import org.springframework.data.repository.CrudRepository;

import myapp.model.UserAssociation;

public interface UserAssociationRepository extends CrudRepository<UserAssociation,Integer> {

}
