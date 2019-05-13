package unit_tests.controller;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Produit;
import com.hicouch.back.core.service.ProduitService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProduitControllerTest {

    @MockBean
    ProduitService produitService;

    @MockBean
    ProduitBusiness produitBusiness;

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
}
