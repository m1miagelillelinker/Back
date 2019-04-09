package myapp.controller;

import myapp.business.TagBusiness;
import myapp.model.Tag;
import myapp.service.TagService;

import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping(value = "/tag" , produces = MediaType.APPLICATION_JSON_VALUE )
public class TagController {

    @Autowired
    private TagBusiness tagBusiness;

    @Autowired
    private TagService tagService;
    
    @CrossOrigin
    @GetMapping("/get")
    @ResponseBody
    public Tag getTagById(@RequestParam("tagId") String tagId){
    	return tagService.getTagById(Integer.parseInt(tagId));
    }
    
    @CrossOrigin
    @GetMapping("/getByValue")
    @ResponseBody
    public Tag getTagByValue(@RequestParam("value") String tagValue){
    	return tagService.getTagByValue(tagValue);
    }
    
    @CrossOrigin
    @GetMapping("/gets")
    @ResponseBody
    public List<Tag> getTagsByIds(@RequestParam("tagsIds") List<String> tagsIds){
    	List<Integer> ids = tagsIds.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    	return tagService.getTagsByIds(ids);
    }

    @PutMapping("/newTag")
    public Tag createTag(@RequestBody String tag){
    	return tagService.createTag(tag);
    }

}
