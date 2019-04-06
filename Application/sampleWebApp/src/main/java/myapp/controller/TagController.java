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

    private final TagBusiness tagBusiness;
    private final TagService tagService;

    @Autowired
    public TagController(TagBusiness tagBusiness, TagService tagService) {
        this.tagBusiness = tagBusiness;
        this.tagService = tagService;
    }
}
