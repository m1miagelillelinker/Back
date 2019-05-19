package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.UserBusiness;
import com.hicouch.back.core.controller.SignalementController;
import com.hicouch.back.core.controller.UserController;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
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

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= SignalementController.class, secure =false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserBusiness userBusiness;

    @MockBean
    UserService userService;

    User user;

    @Before
    public void initAll() throws Exception {
        initDatas();
        initMocks();
    }

    private void initMocks() throws Exception {
        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(user);
    }

    private void initDatas() {
        user = new User();
        user.setEmail("test@test.com");
        user.setFirstName("Alxi");
        user.setGender(0);
        user.setId(1);
        user.setIdstatus(1);
        user.setLastlogin(new Date());
        user.setLastName("bels");
        user.setLoginscount(1);
        user.setPassword("pass");
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }

    @Test
    public void getUserByIdOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getUserByIdNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

}
