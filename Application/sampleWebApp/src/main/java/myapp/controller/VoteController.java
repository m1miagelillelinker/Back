package myapp.controller;

import myapp.business.VoteBusiness;
import myapp.model.Abonnement;
import myapp.model.Vote;
import myapp.service.VoteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @CrossOrigin
    @PutMapping("/vote")
    @ResponseBody
    public Vote upsertVote(@RequestBody Vote vote){
       return voteService.upsertVote(vote);
    }
    
    @CrossOrigin
    @PutMapping("/unvote")
    @ResponseBody
    public void deleteVote(@RequestBody Vote vote){
       voteService.deleteVote(vote);
    }
    
    @CrossOrigin
    @GetMapping("/userVote")
    @ResponseBody
    public List<Vote> getVotesByUser(@RequestParam("userId") int userId){
       return voteService.getVotesByUser(userId);
    }
    
    @CrossOrigin
    @GetMapping("/AssoVote")
    @ResponseBody
    public List<Vote> getVotesByAssociation(@RequestParam("assoId") int assoId){
       return voteService.getVotesByAssociation(assoId);
    }
}
