package myapp.controller;

import myapp.business.TagBusiness;
import myapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tag" , produces = MediaType.APPLICATION_JSON_VALUE )
public class TagController {

    @Autowired
    private TagBusiness tagBusiness;

    @Autowired
    private TagService tagService;

}
