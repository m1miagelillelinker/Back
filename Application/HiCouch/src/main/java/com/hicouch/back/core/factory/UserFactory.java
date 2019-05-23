package com.hicouch.back.core.factory;

import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.UserService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private UserService userService;

    @Autowired
    public UserFactory(UserService userService) {
        super();
        this.userService = userService;
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
        return userDTO;
    }
}
