package myapp.controller;


import myapp.business.UserBusiness;
import myapp.model.User;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(Integer.parseInt(userId));
    }

}
