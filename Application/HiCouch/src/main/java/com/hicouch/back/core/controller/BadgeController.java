package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.BadgeBusiness;
import com.hicouch.back.core.model.Badge;
import com.hicouch.back.core.service.BadgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/badge" , produces = MediaType.APPLICATION_JSON_VALUE )
public class BadgeController {

    private final BadgeBusiness badgeBusiness;
    private final BadgeService badgeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BadgeController(BadgeBusiness badgeBusiness, BadgeService badgeService) {
        this.badgeBusiness = badgeBusiness;
        this.badgeService = badgeService;
    }

    /**
     * Get a user's badges
     * @param userId the id of the user
     * @return a list of badges
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/ByUserId")
    @ResponseBody
    public List<Badge> getBadgesByUserId(@RequestParam("userId") Integer userId) throws Exception {
        logger.trace("getCommentaireByUserId:"+userId);
        return badgeBusiness.getUserBadges(userId);
    }


}
