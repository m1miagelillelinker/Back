package com.hicouch.back.core.business;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.model.TagProduit;
import com.hicouch.back.core.service.TagProduitService;
import com.hicouch.back.core.service.TagService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


@RunWith(SpringRunner.class)
@WebMvcTest(value= TagBusiness.class, secure =false)
public class TagBusinessTest {

    //@Autowired
    private TagBusiness tagBusiness;

    @MockBean
    private TagService tagService;

    @MockBean
    private TagProduitService tagProduitService;

    private Tag tag;
    private TagProduit tagProduit;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
        Mockito.when(tagService.createOrGetTag(Mockito.anyString())).thenReturn(tag);
        Mockito.when(tagProduitService.newTagProduit(Mockito.anyInt(),Mockito.anyString())).thenReturn(tagProduit);
    }

    private void initDatas() {
        tag = new Tag();
        tag.setId(1);
        tag.setStatus(1);
        tag.setValue("test");

        tagProduit = new TagProduit();
        tagProduit.setId(1);
        tagProduit.setIdProduit("1");
        tagProduit.setIdTag(1);
    }

    @Test
    public void setTagOnProductOk(){
        tagBusiness.setTagOnProduct("1","1");

    }

    @Test(expected = Exception.class)
    public void setTagOnProductEmpty(){
        tagBusiness.setTagOnProduct("","");
    }

    @Test(expected = Exception.class)
    public void setTagOnProductNull(){
        tagBusiness.setTagOnProduct(null,null);
    }

    @Test(expected = Exception.class)
    public void setTagOnProductCreateOrGetTagFailed(){
        Mockito.when(tagService.createOrGetTag(Mockito.anyString())).thenReturn(tag);

    }

    @Test(expected = Exception.class)
    public void setTagOnProductCreateOrGetTagNull(){
        Mockito.when(tagService.createOrGetTag(Mockito.anyString())).thenReturn(tag);

    }

    @Test(expected = Exception.class)
    public void setTagOnProductNewTagProduitFailed(){
        Mockito.when(tagProduitService.newTagProduit(Mockito.anyInt(),Mockito.anyString())).thenReturn(null);
    }

    @Test(expected = Exception.class)
    public void setTagOnProductNewTagProduitNull(){
        Mockito.when(tagProduitService.newTagProduit(Mockito.anyInt(),Mockito.anyString())).thenReturn(null);
    }



}
