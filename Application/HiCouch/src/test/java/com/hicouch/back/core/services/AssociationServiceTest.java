package com.hicouch.back.core.services;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.service.AssociationService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AssociationServiceTest.class, secure = false)
public class AssociationServiceTest {

    @Autowired
    AssociationService associationService;

    @MockBean
    AssociationRepository associationRepository;

    Association a;
    Association b;
    String idProduct;
    List<AssociationDTO> associationDTOList;
    List<Association> associationList;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
        Mockito.when(associationRepository.findAllByIdproduitA(idProduct)).thenReturn(associationList);
        Mockito.doNothing().
    }

    private void initDatas() {
        a = new Association();
        b = new Association();
        idProduct = "1";
    }


}
