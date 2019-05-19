package com.hicouch.back.core.controller;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.controller.ProduitController;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Produit;
import com.hicouch.back.core.service.ProduitService;
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
@WebMvcTest(value= ProduitController.class, secure =false)
public class ProduitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduitService produitService;

    @MockBean
    private ProduitBusiness produitBusiness;

    ProductDTO productDTO;
    Produit product;
    List<ProductDTO> productDTOList;


    @Before
    public void initAll() throws Exception {
        initDatas();
        initMocks();
    }

    private void initMocks() throws Exception {
        Mockito.when(produitService.getBookByIdFromReferentiel(Mockito.anyString())).thenReturn(productDTO);
        Mockito.when(produitService.getFilmByIdFromReferentiel(Mockito.anyString())).thenReturn(productDTO);
        Mockito.when(produitService.getFilmByTitleFromReferentiel(Mockito.anyString())).thenReturn(productDTO);
        Mockito.when(produitService.getFilmsByTitleFromReferentiel(Mockito.anyString())).thenReturn(productDTOList);
        Mockito.when(produitService.getGameByIdFromReferentiel(Mockito.anyString())).thenReturn(productDTO);
        Mockito.when(produitService.getProductByIdFromReferentiel(Mockito.anyString(),Mockito.anyString())).thenReturn(productDTO);

    }

    private void initDatas() {
        productDTO = new ProductDTO();
        productDTO.setCountry("FR");
        productDTO.setDescription("bla");
        productDTO.setDirector("Me");
        productDTO.setId("1");
        productDTO.setImage("no");
        productDTO.setTitle("please i wanna die");
        productDTO.setType("book");
        productDTO.setYear("2019");

        productDTOList.add(productDTO);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }

    @Test
    public void getFilmByIdFromReferentielOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getFilmByIdFromReferentielNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getFilmsByTitleFromReferentielNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getFilmsByTitleFromReferentielOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getFilmByTitleFromReferentielOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }


    @Test
    public void getFilmByTitleFromReferentielNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getBookByIdFromReferentielNull() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

    @Test
    public void getBookByIdFromReferentielOk() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "";

        JSONAssert.assertEquals(expected,result.getRequest().getContentAsString(),true);

    }

}
