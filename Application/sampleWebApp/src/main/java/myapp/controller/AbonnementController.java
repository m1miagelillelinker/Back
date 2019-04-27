package myapp.controller;

import myapp.business.AbonnementBusiness;
import myapp.model.Abonnement;
import myapp.model.User;
import myapp.service.AbonnementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/abonnement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AbonnementController {

    @Autowired
    private AbonnementBusiness abonnementBusiness;
    
    @Autowired
    private AbonnementService abonnementService;
    
    @CrossOrigin
    @GetMapping("/followers")
    @ResponseBody
    public List<Abonnement> getFollowersById(@RequestParam("userId") String userId){
        System.out.println(userId);

        List<Abonnement> abonnements = abonnementService.getFollowersByFollows(userId);

        return abonnements;
    }
    
    @CrossOrigin
    @GetMapping("/follows")
    @ResponseBody
    public List<Abonnement> getFollowsById(@RequestParam("userId") String userId){
        System.out.println(userId);

        List<Abonnement> abonnements = abonnementService.getFollowsByFollower(userId);

        return abonnements;
    }
    
    // post A follow B
    @CrossOrigin
    @PutMapping("/follow")
    @ResponseBody
    public Abonnement follow(@RequestParam("follower") String follower, @RequestParam("follows") String follows){
        return abonnementService.follow(follower, follows);
    }
    
    // delete A follow B
    @CrossOrigin
    @DeleteMapping("/unfollow")
    @ResponseBody
    public void unfollow(@RequestParam("follower") String follower, @RequestParam("follows") String follows){
        abonnementService.unfollow(follower, follows);
    }

}
