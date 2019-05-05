package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.SignalementBusiness;
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
    public Signalement getSignalementById(@RequestParam("signalementId") String signalementId){
    	return signalementService.getSignalementById(Integer.parseInt(signalementId));
    }

    @CrossOrigin
    @PutMapping("/newSignalement")
    @ResponseBody
    public Signalement createSignalement(@RequestBody Signalement signalement){
    	return signalementService.createSignalement(signalement);
    }
    
    @CrossOrigin
    @GetMapping("/list")
    @ResponseBody
    public List<Signalement> getSignalementByStatus(@RequestParam("status") int status){
    	return signalementService.findAllSignalementsInStatus(status);
    }

}
