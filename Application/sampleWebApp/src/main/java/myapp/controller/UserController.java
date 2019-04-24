package myapp.controller;


import myapp.business.UserBusiness;
import myapp.model.User;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//modifié pour répondre aux query en POST du type
// curl -i -d userId=2 http://localhost:8080/user

//l'objectif actuel est de répondre a l'appel
// curl -i -d userId=2 -d username=user -d password=userPass http://localhost:8080/user sans recevoir un "status":401,"error":"Unauthorized"

@RestController
public class UserController {

    private final UserBusiness userBusiness;
    private final UserService userService;


    @Autowired
    public UserController(UserBusiness userBusiness, UserService userService) {
        this.userBusiness = userBusiness;
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public User user(@RequestParam(value="userId", defaultValue="1") String userId){
        System.out.println(userId);

        User user = userService.getUserById(Integer.parseInt(userId));

        return user;
    }

}
