package unit_tests.controller;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.AssociationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AssociationControllerTest {

    @MockBean
    AssociationBusiness associationBusiness;

    @MockBean
    AssociationService associationService;

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
}
