package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	
	Optional<User> getUserByIdAuth0(String idAuth0);


}