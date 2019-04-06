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

	@Autowired
    private UserBusiness userBusiness;

	@Autowired
	private UserService userService;

    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public User getUserById(@RequestParam("userId") String userId){
        System.out.println(userId);

        User user = userService.getUserById(Integer.parseInt(userId));

        return user;
    }

}