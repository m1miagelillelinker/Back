package com.hicouch.back.core.controller;


import com.hicouch.back.core.business.UserBusiness;
import com.hicouch.back.core.exception.NoResultException;
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


    @Autowired
    public UserController(UserBusiness userBusiness, UserService userService) {
        this.userBusiness = userBusiness;
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public User getUserById(@RequestParam("userId") String userId) throws NumberFormatException, NoResultException {
        return  userService.getUserById(Integer.parseInt(userId));
    }
    
    @CrossOrigin
    @GetMapping("/current")
    @ResponseBody
    public User getCurrentUser() throws NoResultException {
        return userService.getCurrentUser();
    }
    
    @CrossOrigin
    @PutMapping("/update")
    @ResponseBody
    public User updateCurrentUser(@RequestBody User user) throws NoResultException {
        return userService.updateUser(user);
    }

}
