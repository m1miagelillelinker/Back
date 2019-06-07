package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.UserRepository;
import com.hicouch.back.core.enumeration.TypeUser;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) throws NoResultException {

    	System.out.println("info : ");
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return userRepository.findById(userId).orElseThrow(NoResultException::new);
    }

	@Override
	public User setUserStatus(int userId, int status) throws NoResultException {
		User user = userRepository.findById(userId).orElseThrow(NoResultException::new);
		user.setIdstatus(status);
		return userRepository.save(user);
	}

	@Override
	public User getUserByAuth0Id(String userId) throws NoResultException {
		return userRepository.getUserByIdAuth0(userId).orElseThrow(NoResultException::new);
	}

	@Override
	public User getCurrentUser() throws NoResultException {
		String auth0Id = SecurityContextHolder.getContext().getAuthentication().getName();
		return getUserByAuth0Id(auth0Id);
	}

	@Override
	public boolean isModeratorOrAdmin(User user) {
		return TypeUser.MODERATOR == user.getTypeUser() || TypeUser.ADMIN == user.getTypeUser();
	}
}
