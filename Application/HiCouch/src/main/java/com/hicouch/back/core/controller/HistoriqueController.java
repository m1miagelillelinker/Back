package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/historique", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoriqueController {

    private final HistoriqueBusiness historiqueBusiness;
    private final HistoriqueService historiqueService;
    private final UserService userService;

    @Autowired
    public HistoriqueController(HistoriqueBusiness historiqueBusiness, HistoriqueService historiqueService, UserService userService){
        this.historiqueBusiness = historiqueBusiness;
        this.historiqueService = historiqueService;
        this.userService = userService;
    }


    @CrossOrigin
    @GetMapping("/{id}")
    @ResponseBody
    public Historique getHistoriqueById(@PathVariable("id") Integer id){
        if( id != null ){
            return historiqueService.getHistoriqueByIdUser(id);
        }
        return null;
    }

    @CrossOrigin
    @PostMapping("/addEvent")
    @ResponseBody
    public void addEventToMyHistorique(@RequestParam("Event") String event, @RequestParam("id") int id){
       historiqueService.addToHistorique(event,id);
    }

    @CrossOrigin
    @PostMapping("/createHistory")
    public Historique createHistory(@RequestParam("id") String id) throws NoResultException {
        return historiqueService.createHistorique(id,new ArrayList<>(),userService.getCurrentUser().getPseudo());
    }
}
