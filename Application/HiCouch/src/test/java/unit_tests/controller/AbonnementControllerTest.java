package unit_tests.controller;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.service.AbonnementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= AbonnementControllerTest.class, secure =false)
public class AbonnementControllerTest {

    @MockBean
    AbonnementBusiness abonnementBusiness;

    @MockBean
    AbonnementService abonnementService;

    Abonnement abonnement;
    Abonnement follower;
    Integer userId;
    List<Abonnement> listAbo;
    List<Abonnement> listAbo2;

    @Before
    public void initAll(){
        initDatas();
        initMocks();
    }

    private void initMocks() {
        Mockito.when(abonnementService.follow(Mockito.anyInt(),Mockito.anyInt())).thenReturn(abonnement);
        Mockito.when(abonnementService.getFollowersByFollows(Mockito.anyInt())).thenReturn(listAbo);
        Mockito.when(abonnementService.getFollowsByFollower(Mockito.anyInt())).thenReturn(listAbo2);

    }

    private void initDatas() {
        abonnement = new Abonnement();
        abonnement.setFollower(1);
        abonnement.setFollows(2);
        abonnement.setIdabonnement(5);
        userId =15;

        follower = new Abonnement();
        follower.setIdabonnement(5);
        follower.setFollows(1);
        follower.setFollower(2);

        listAbo.add(follower);
        listAbo2.add(abonnement);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }


    @Test
    public void getFollowersByIdOk(){}

    @Test
    public void getFollowersByIdNull(){}

    @Test
    public void getFollowersByIdEmpty(){}


    @Test
    public void getFollowsByIdOk(){}

    @Test
    public void getFollowsByIdNull(){}

    @Test
    public void getFollowsByIdEmpty(){}

    @Test
    public void followOk(){}

    @Test
    public void followNull(){}

    @Test
    public void followEmpty(){}

    @Test
    public void unfollowOk(){}

    @Test
    public void unfollowNull(){}

    @Test
    public void unfollowEmpty(){}




}
