package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.SignalementBusiness;
import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.enumeration.SignalementTypeEnum;
import com.hicouch.back.core.enumeration.StatusEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.service.SignalementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/signalement" , produces = MediaType.APPLICATION_JSON_VALUE )
public class SignalementController {

	private final SignalementBusiness signalementBusiness;
    private final SignalementService signalementService;

    @Autowired
    public SignalementController(SignalementBusiness signalementBusiness, SignalementService signalementService) {
        this.signalementBusiness = signalementBusiness;
        this.signalementService = signalementService;
    }

    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public Signalement getSignalementById(@RequestParam("signalementId") int signalementId) throws NoResultException{
    	return signalementService.getSignalementById(signalementId);
    }

    @CrossOrigin
    @PutMapping("/newSignalement")
    @ResponseBody
    public Signalement createSignalement(@RequestBody Signalement signalement){
    	return signalementService.createSignalement(signalement);
    }
    
    @CrossOrigin
    @GetMapping("/toModerate/comment")
    @ResponseBody
    public List<SignalementDTO> getSignaledCommentToModerate(){
    	return signalementService.findAllSignalementsByTypeAndStatus(StatusEnum.TO_MODERATE, SignalementTypeEnum.COMMENTAIRE);
    }
    
    @CrossOrigin
    @GetMapping("/toModerate/user")
    @ResponseBody
    public List<SignalementDTO> getSignaledUserToModerate(){
    	return signalementService.findAllSignalementsByTypeAndStatus(StatusEnum.TO_MODERATE, SignalementTypeEnum.UTILISATEUR);
    }
    
    @CrossOrigin
    @PutMapping("/confirmeSignalement")
    @ResponseBody
    public SignalementDTO confirmeSignalement(@RequestParam("signalementId") int signalementId) throws NoResultException {
    	return signalementBusiness.processSignalement(signalementId, StatusEnum.BLOCKED);
    }
    
    @CrossOrigin
    @PutMapping("/refuseSignalement")
    @ResponseBody
    public SignalementDTO refuseSignalement(@RequestParam("signalementId") int signalementId) throws NoResultException {
    	return signalementBusiness.processSignalement(signalementId, StatusEnum.OK);
    }

}
