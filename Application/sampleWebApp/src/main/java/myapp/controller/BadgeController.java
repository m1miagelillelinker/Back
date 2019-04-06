package myapp.controller;

import myapp.business.BadgeBusiness;
import myapp.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/badge" , produces = MediaType.APPLICATION_JSON_VALUE )
public class BadgeController {

    @Autowired
    private BadgeBusiness badgeBusiness;
    
    @Autowired
    private BadgeService badgeService;

}
