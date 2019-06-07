package com.hicouch.back.core.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SignalementServiceTest.class, secure = false)
public class SignalementServiceTest {

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
