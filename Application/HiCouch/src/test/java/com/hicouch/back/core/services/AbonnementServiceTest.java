package com.hicouch.back.core.services;

import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.repository.AbonnementRepository;
import com.hicouch.back.core.service.AbonnementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AbonnementServiceTest.class, secure = false)
public class AbonnementServiceTest {

    @MockBean
    AbonnementRepository abonnementRepository;

    @Autowired
    private AbonnementService abonnementService;

    Abonnement abonnement;
    int userId = 1;
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
        Mockito.doNothing().when(abonnementRepository).delete(Mockito.any(Abonnement.class));
    }

    private void initDatas() {
        abonnementList = new ArrayList<>();


        abonnement = new Abonnement();
        abonnement.setFollower(1);
        abonnement.setFollows(1);
        abonnement.setIdabonnement(1);
        abonnement.setCreatedat(new Date());
        abonnement.setUpdatedAt(new Date());


        abo = Optional.of(abonnement);
        abonnementList.add(abonnement);

    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }


    @Test
    public void getFollowersByFollowsOK() {
        Assert.assertEquals(abonnementList.toString(),abonnementService.getFollowersByFollows(userId).toString());
    }

    @Test(expected = Exception.class)
    public void getFollowersByFollowsDbErr() {
        Mockito.when(abonnementRepository.findAllByFollower(userId)).thenThrow(new Exception()) ;
        abonnementService.getFollowersByFollows(userId);
    }

    @Test
    public void getFollowersByFollowsDbReturnNull() {
        Mockito.when(abonnementRepository.findAllByFollower(userId)).thenReturn(null) ;
        abonnementService.getFollowersByFollows(userId);
    }

    @Test
    public void getFollowsByFollowerOk() {
        Assert.assertEquals(abonnementList.toString(),abonnementService.getFollowsByFollower(userId).toString());
    }

    @Test(expected = Exception.class)
    public void getFollowsByFollowerDbErr(){
        Mockito.when(abonnementRepository.findAllByFollows(userId)).thenThrow(new Exception());
    }

    @Test
    public void getFollowsByFolloweDbReturnNull(){
        Mockito.when(abonnementRepository.findAllByFollows(userId)).thenReturn(null);
    }

    @Test
    public void followOk(){
        Assert.assertEquals(abonnement.toString(),abonnementService.follow(1,1).toString());
    }

    @Test(expected = Exception.class)
    public void followDbErr(){
        Mockito.when(abonnementRepository.save(Mockito.any(Abonnement.class))).thenThrow(new Exception());
        abonnementService.follow(1,1);
    }

    @Test
    public void unfollowOk(){
        Mockito.verify(abonnementRepository,Mockito.times(1)).findByFollowerAndFollows(1,1);
        Mockito.verify(abonnementRepository,Mockito.times(1)).delete(Mockito.any(Abonnement.class));
    }

    @Test(expected = Exception.class)
    public void unfollowDbrErr(){
        Mockito.when(abonnementRepository.findByFollowerAndFollows(1,1)).thenThrow(new Exception());
        abonnementService.unfollow(1,1);
    }
}
