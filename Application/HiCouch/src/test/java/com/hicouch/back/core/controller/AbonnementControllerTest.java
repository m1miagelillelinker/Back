package com.hicouch.back.core.controller;

import com.hicouch.back.core.Application;
import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.controller.AbonnementController;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.service.AbonnementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= AbonnementController.class, secure =false)
public class AbonnementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbonnementBusiness abonnementBusiness;

    @MockBean
    private AbonnementService abonnementService;

    Abonnement abonnement;
    Abonnement follower;
    Integer userId;
    List<Abonnement> listAbo;
    List<Abonnement> listAbo2;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
        Mockito.when(abonnementService.follow(Mockito.anyInt(),Mockito.anyInt())).thenReturn(abonnement);
        Mockito.when(abonnementService.getFollowersByFollows(Mockito.anyInt())).thenReturn(listAbo);
        Mockito.when(abonnementService.getFollowsByFollower(Mockito.anyInt())).thenReturn(listAbo2);

    }

    private void initDatas() {
        abonnement = new Abonnement();
        abonnement.setFollower(1);
        abonnement.setFollows(2);
        abonnement.setIdabonnement(5);
        userId =15;

        follower = new Abonnement();
        follower.setIdabonnement(5);
        follower.setFollows(1);
        follower.setFollower(2);

        listAbo = new ArrayList<>();
        listAbo2 = new ArrayList<>();

        listAbo.add(follower);
        listAbo2.add(abonnement);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }


    @Test
    public void getFollowersByIdOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/followers?userId=15")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "et";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }


    @Test
    public void getFollowersByIdNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/followers?userId=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "t";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void getFollowersByIdEmpty() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/followers?")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "t";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }


    @Test
    public void getFollowsByIdOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/follows?userId=15")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "t";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void getFollowsByIdNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/follows?userId=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "test";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void getFollowsByIdEmpty() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abonnement/follows?")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "test";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void followOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/abonnement/follow?follower=1&follow=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void followNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/abonnement/follow?follower=1&follow=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void followEmpty() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/abonnement/follow")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void unfollowOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/abonnement/unfollow?follower=1&follows=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void unfollowNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/abonnement/unfollow?follower=1&follows=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }

    @Test
    public void unfollowEmpty() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/abonnement/unfollow")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }
}
