package com.hicouch.back.core.service;

import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;

public interface UserService {
    User getUserById(Integer userId) throws NoResultException;
	User setUserStatus(int userId, int status) throws NoResultException;
}
