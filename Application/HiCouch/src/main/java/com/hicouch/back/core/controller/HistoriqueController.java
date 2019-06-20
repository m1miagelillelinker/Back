package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.HistoriqueBusiness;
import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public List<HistoriqueDTO> getHistoriqueById(@PathVariable("id") Integer id){
        if( id != null ){
            return historiqueBusiness.getHistoriqueByIdUser(id);
        }
        return null;
    }

}
