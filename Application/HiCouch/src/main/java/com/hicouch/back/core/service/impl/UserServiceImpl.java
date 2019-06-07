package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.repository.UserRepository;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) throws NoResultException {
        return userRepository.findById(userId).orElseThrow(NoResultException::new);
    }

	@Override
	public User setUserStatus(int userId, int status) throws NoResultException {
		User user = userRepository.findById(userId).orElseThrow(NoResultException::new);
		user.setIdstatus(status);
		return userRepository.save(user);
	}
}
