package com.hicouch.back.core.service;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User getUserById(Integer userId) throws Exception;

    UserDetails loadUserByUsername(String name);
}
