package unit_tests.services;

import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.repository.AbonnementRepository;
import com.hicouch.back.core.service.AbonnementService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AbonnementServiceTest {

    @MockBean
    AbonnementRepository abonnementRepository;

    Abonnement abonnement;

    Optional<Abonnement> abo;

    List<Abonnement> abonnementList;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
        Mockito.when(abonnementRepository.save(Mockito.any(Abonnement.class))).thenReturn(abonnement);
        Mockito.when(abonnementRepository.findAllByFollower(Mockito.anyInt())).thenReturn(abonnementList);
        Mockito.when(abonnementRepository.findAllByFollows(Mockito.anyInt())).thenReturn(abonnementList);
        Mockito.when(abonnementRepository.findByFollowerAndFollows(Mockito.anyInt(),Mockito.anyInt())).thenReturn(abo);
        Mockito.when(abonnementRepository.findAll()).thenReturn(abonnementList);
    }

    private void initDatas() {
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }
}
