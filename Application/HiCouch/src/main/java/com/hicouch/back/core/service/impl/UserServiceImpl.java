package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.UserRepository;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(NoResultException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String name) {
        return userRepository.findUserByEmail(name).get();
    }
}
