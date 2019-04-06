package myapp.controller;

import myapp.business.VoteBusiness;
import myapp.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vote" , produces = MediaType.APPLICATION_JSON_VALUE )
public class VoteController{

	@Autowired
    private VoteBusiness voteBusiness;
	
	@Autowired
    private VoteService voteService;

}
