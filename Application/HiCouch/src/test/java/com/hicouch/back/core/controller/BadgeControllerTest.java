package com.hicouch.back.core.controller;

import com.hicouch.back.core.controller.BadgeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= BadgeController.class, secure =false)
public class BadgeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
    }

    private void initDatas() {
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }


}
