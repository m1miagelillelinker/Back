package myapp.repository;

import org.springframework.data.repository.CrudRepository;

import myapp.model.BadgeUser;

public interface BadgeUserRepository extends CrudRepository<BadgeUser,Integer>{

}
