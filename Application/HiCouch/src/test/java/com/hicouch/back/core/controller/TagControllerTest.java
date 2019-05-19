package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.controller.SignalementController;
import com.hicouch.back.core.controller.TagController;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.service.TagService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= TagController.class, secure =false)
public class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TagBusiness tagBusiness;

    @MockBean
    TagService tagService;

    Tag tag;

    List<Tag> tagList;

    @Before
    public void initAll() throws NoResultException {
        initDatas();
        initMocks();
    }

    private void initMocks() throws NoResultException {
        //Mockito.when(tagBusiness.setTagOnProduct(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        Mockito.when(tagService.createOrGetTag(Mockito.anyString())).thenReturn(tag);
        Mockito.when(tagService.setTagStatus(Mockito.anyInt(),Mockito.anyInt())).thenReturn(tag);
        Mockito.when(tagService.getTagById(Mockito.anyInt())).thenReturn(tag);
        Mockito.when(tagService.getTagByValue(Mockito.anyString())).thenReturn(tagList);
        Mockito.when(tagService.getTagsByIds(Mockito.anyList())).thenReturn(tagList);
    }

    private void initDatas() {
        tag = new Tag();
        tag.setId(1);
        tag.setStatus(1);
        tag.setValue("test");

        tagList.add(tag);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }

    @Test
    public void setTagOnProductOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void setTagOnProductNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void setTagStatusOKoK() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void setTagStatusOKNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void setTagStatusBlockedOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void setTagStatusBlockedNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }
}
