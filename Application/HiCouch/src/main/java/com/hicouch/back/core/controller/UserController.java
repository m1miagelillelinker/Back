package com.hicouch.back.core.controller;


import com.hicouch.back.core.business.UserBusiness;
import com.hicouch.back.core.dto.UserDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.UserFactory;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    private final UserBusiness userBusiness;
    private final UserService userService;
    private final UserFactory userFactory;


    @Autowired
    public UserController(UserBusiness userBusiness, UserService userService, UserFactory userFactory) {
        this.userBusiness = userBusiness;
        this.userService = userService;
        this.userFactory = userFactory;
    }

    /**
     * Get a user
     * @param userId the id of the user
     * @return a User
     * @throws NumberFormatException
     * @throws NoResultException
     */
    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public UserDTO getUserById(@RequestParam("userId") String userId) throws NumberFormatException, NoResultException {
        return  userFactory.getUserDTO(userService.getUserById(Integer.parseInt(userId)));
    }
    
    /**
     * Get the connected user
     * @return a user
     * @throws NoResultException
     */
    @CrossOrigin
    @GetMapping("/current")
    @ResponseBody
    public User getCurrentUser() throws NoResultException {
        return userService.getCurrentUser();
    }
    
    /**
     * Update a user's infos
     * @param user the user
     * @return the user
     * @throws NoResultException
     */
    @CrossOrigin
    @PutMapping("/update")
    @ResponseBody
    public User updateCurrentUser(@RequestBody User user) throws NoResultException {
        return userService.updateUser(user);
    }

}
