package com.hicouch.back.core.factory;

import com.hicouch.back.core.business.BadgeBusiness;
import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private UserService userService;
    private BadgeBusiness badgeBusiness;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserFactory(UserService userService,BadgeBusiness badgeBusiness) {
        super();
        this.userService = userService;
        this.badgeBusiness = badgeBusiness;
    }

    public UserDTO getUserDTO(User user) throws NoResultException {

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setTypeUser(user.getTypeUser());
        userDTO.setPseudo(user.getPseudo());
        userDTO.setScore(user.getScore());
        userDTO.setIdstatus(user.getIdstatus());
        userDTO.setPicture(user.getPicture());
        userDTO.setLastlogin(user.getLastlogin());
        userDTO.setBadges(badgeBusiness.getUserBadges(user.getId()));
        userDTO.setIduser(user.getId());
        return userDTO;
    }
}
