package myapp.controller;


import myapp.business.UserBusiness;
import myapp.model.User;
import myapp.service.UserService;
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

    @GetMapping("/get")
    @ResponseBody
    public String getUserById(@RequestParam(required = false) String userId){
        System.out.println(userId);

        String user = userService.
                getUserById(Integer.parseInt(userId))
                .toString();

        return user;


    }

}
