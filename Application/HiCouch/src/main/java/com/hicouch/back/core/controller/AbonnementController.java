package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/abonnement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class AbonnementController {

    private final AbonnementBusiness abonnementBusiness;
    private final AbonnementService abonnementService;


    @Autowired
    public AbonnementController(AbonnementBusiness abonnementBusiness, AbonnementService abonnementService){
        this.abonnementBusiness = abonnementBusiness;
        this.abonnementService = abonnementService;
    }

    /**
     * Get the list of users following userId
     * @param userId
     * @return a list of users
     */
    @CrossOrigin
    @GetMapping("/followers")
    @ResponseBody
    public List<User> getFollowersById(@RequestParam("userId") int userId){
        return abonnementBusiness.getFollowersByFollows(userId);
    }

    /**
     * Get the list of users that userId follow
     * @param userId
     * @return a list of users
     */
    @CrossOrigin
    @GetMapping("/follows")
    @ResponseBody
    public List<User> getFollowsById(@RequestParam("userId") int userId){
        return abonnementBusiness.getFollowsByFollower(userId);
    }

    // post A follow B
    /**
     * Create a subscription of follower to follows
     * @param follower
     * @param follows
     * @return the subscription
     */
    @CrossOrigin
    @PutMapping("/follow")
    @ResponseBody
    public Abonnement follow(@RequestParam("follower") Integer follower, @RequestParam("follows") Integer follows){
        return abonnementService.follow(follower, follows);
    }

    // delete A follow B
    /**
     * Delete the subscription of follower to follow
     * @param follower
     * @param follows
     */
    @CrossOrigin
    @DeleteMapping("/unfollow")
    @ResponseBody
    public void unfollow(@RequestParam("follower") Integer follower, @RequestParam("follows") Integer follows){
        abonnementService.unfollow(follower, follows);
    }

}
