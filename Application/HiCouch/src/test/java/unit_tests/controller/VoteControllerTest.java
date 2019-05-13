package unit_tests.controller;

import com.hicouch.back.core.business.VoteBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.VoteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VoteControllerTest {

    @MockBean
    VoteService voteService;

    @MockBean
    VoteBusiness voteBusiness;

    Vote vote;

    List<Vote> voteList;


    @Before
    public void initAll() throws NoResultException {
        initDatas();
        initMocks();
    }

    private void initMocks() throws NoResultException {
        Mockito.when(voteService.getVoteByUserOnAsso(Mockito.anyInt(),Mockito.anyInt())).thenReturn(vote);
        Mockito.when(voteService.getVotesByAssociation(Mockito.anyInt())).thenReturn(voteList);
        Mockito.when(voteService.getVotesByUser(Mockito.anyInt())).thenReturn(voteList);
        Mockito.when(voteService.upsertVote(Mockito.any(Vote.class))).thenReturn(vote);
    }

    private void initDatas() {
        vote.setVote(1);
        vote.setId(1);
        vote.setIdPair(1);
        vote.setIdUser(1);

        voteList.add(vote);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }
}
