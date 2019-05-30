package com.hicouch.back.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hicouch.back.core.model.User;
import com.hicouch.back.core.repository.UserRepository;

import static java.util.Collections.emptyList;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.userRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getUserByIdAuth0(username);
        // check that user exists
        if (optionalUser == null || !optionalUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User("djoulbi", "", emptyList());
    }
}
