package unit_tests.controller;

import com.hicouch.back.core.business.UserBusiness;
import com.hicouch.back.core.controller.UserController;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    @MockBean
    UserBusiness userBusiness;

    @MockBean
    UserService userService;

    User user;

    @Before
    public void initAll() throws Exception {
        initDatas();
        initMocks();
    }

    private void initMocks() throws Exception {
        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(user);
    }

    private void initDatas() {
        user = new User();
        user.setEmail("test@test.com");
        user.setFirstName("Alxi");
        user.setGender(0);
        user.setId(1);
        user.setIdstatus(1);
        user.setLastlogin(new Date());
        user.setLastName("bels");
        user.setLoginscount(1);
        user.setPassword("pass");
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }
}
