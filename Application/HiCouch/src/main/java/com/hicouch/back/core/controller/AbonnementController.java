package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.service.AbonnementService;

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

    private final AbonnementBusiness abonnementBusiness;
    private final AbonnementService abonnementService;


    @Autowired
    public AbonnementController(AbonnementBusiness abonnementBusiness, AbonnementService abonnementService){
        this.abonnementBusiness = abonnementBusiness;
        this.abonnementService = abonnementService;
    }

    @CrossOrigin
    @GetMapping("/followers")
    @ResponseBody
    public List<Abonnement> getFollowersById(@RequestParam("userId") int userId){
        List<Abonnement> abonnements = abonnementService.getFollowersByFollows(userId);

        return abonnements;
    }

    @CrossOrigin
    @GetMapping("/follows")
    @ResponseBody
    public List<Abonnement> getFollowsById(@RequestParam("userId") int userId){
        List<Abonnement> abonnements = abonnementService.getFollowsByFollower(userId);

        return abonnements;
    }

    // post A follow B
    @CrossOrigin
    @PutMapping("/follow")
    @ResponseBody
    public Abonnement follow(@RequestParam("follower") Integer follower, @RequestParam("follows") Integer follows){
        return abonnementService.follow(follower, follows);
    }

    // delete A follow B
    @CrossOrigin
    @DeleteMapping("/unfollow")
    @ResponseBody
    public void unfollow(@RequestParam("follower") Integer follower, @RequestParam("follows") Integer follows){
        abonnementService.unfollow(follower, follows);
    }

}
