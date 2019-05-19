package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.controller.AssociationController;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.AssociationService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= AssociationController.class, secure =false)
public class AssociationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssociationBusiness associationBusiness;

    @MockBean
    private AssociationService associationService;

    Association association;
    AssociationDTO associationDTO;
    List<AssociationDTO> listAsso;

    @Before
    public void initAll() throws Exception {
        initDatas();
        initMocks();
    }

    private void initMocks() throws Exception {
        Mockito.when(associationService.createAssociation(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(association);
        Mockito.when(associationService.deleteAssociation(Mockito.anyInt())).thenReturn("Ok");
        Mockito.when(associationService.getAssociationsByIdProduct(Mockito.anyString())).thenReturn(listAsso);

    }

    private void initDatas() {
        association = new Association();
        association.setId(1);
        association.setIdfournA("2");
        association.setIdfournB("3");
        association.setIdPair(1);
        association.setIdproduitA("1");
        association.setIdproduitB("2");

        associationDTO = new AssociationDTO();
        associationDTO.setAssociation(association);
        associationDTO.setCommentaires(new ArrayList<>());
        associationDTO.setProduct(new ProductDTO());
        associationDTO.setVote(new Vote());
        associationDTO.setNote(1);

        listAsso.add(associationDTO);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }

    @Test
    public void getAssociationsByIdProductOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getAssociationsByIdProductNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void createAssociationOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void createAssociationNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void deleteAssociationNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void deleteAssociationOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);
    }



}
