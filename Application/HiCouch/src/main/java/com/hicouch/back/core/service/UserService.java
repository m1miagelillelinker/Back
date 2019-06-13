package com.hicouch.back.core.service;

import java.util.Optional;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;

public interface UserService {
    User getUserById(Integer userId) throws NoResultException;
    Optional<User> getUserByAuth0Id(String userId) throws NoResultException;
	User setUserStatus(int userId, int status) throws NoResultException;
	User getCurrentUser() throws NoResultException;
	User updateUser(User user) throws NoResultException;
	boolean isModeratorOrAdmin(User user);
}
