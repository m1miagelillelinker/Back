package myapp.controller;

import myapp.business.StatusBusiness;
import myapp.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/status" , produces = MediaType.APPLICATION_JSON_VALUE )
public class StatusController {

    @Autowired
    private StatusBusiness statusBusiness;

    @Autowired
    private StatusService statusService;
}