package unit_tests.controller;

import com.hicouch.back.core.business.SignalementBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.service.SignalementService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SignalementControllerTest {

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
}
