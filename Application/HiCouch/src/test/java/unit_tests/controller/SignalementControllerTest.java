package unit_tests.controller;

import com.hicouch.back.core.business.SignalementBusiness;
import com.hicouch.back.core.controller.ProduitController;
import com.hicouch.back.core.controller.SignalementController;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.service.SignalementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@WebMvcTest(value= SignalementController.class, secure =false)
public class SignalementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SignalementService signalementService;

    @MockBean
    SignalementBusiness signalementBusiness;

    Signalement signalement;

    List<Signalement> listSignalement;

    @Before
    public void initAll() throws NoResultException {
        initDatas();
        initMocks();
    }

    private void initMocks() throws NoResultException {
        Mockito.when(signalementService.createSignalement(Mockito.any(Signalement.class))).thenReturn(signalement);
        Mockito.when(signalementService.createSignalement(Mockito.anyString(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(signalement);
        Mockito.when(signalementService.findAllSignalementsInStatus(Mockito.anyInt())).thenReturn(listSignalement);
        Mockito.when(signalementService.getSignalementById(Mockito.anyInt())).thenReturn(signalement);
    }

    private void initDatas() {
        signalement = new Signalement();
        signalement.setId(1);
        signalement.setIdUser(5);
        signalement.setMessage("ban moi ce mec");
        signalement.setModeratorId(1);
        signalement.setSignaledCommentId(1);
        signalement.setSignaledUserId(1);
        signalement.setTypeSignalement("urgent");
        signalement.setStatus(1);

        listSignalement.add(signalement);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }

    @Test
    public void getSignalementById() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getSignalementByNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void createSignalementOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void createSignalementNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void listOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void listNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }
}
