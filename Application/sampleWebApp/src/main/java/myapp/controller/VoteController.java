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

    private final VoteBusiness voteBusiness;
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteBusiness voteBusiness, VoteService voteService) {
        this.voteBusiness = voteBusiness;
        this.voteService = voteService;
    }
}
