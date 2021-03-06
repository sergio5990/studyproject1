package sv.kruk.service.imp;

import org.junit.Before;
import org.junit.Test;
import sv.kruk.domain.User;
import sv.kruk.service.UserService;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserServiceImpTest {

    private  UserService userService;


    @Before
    public void setUp() throws Exception {
        userService = UserServiceImp.getInstance();
    }

    @Test
    public void verificationUser() throws Exception {
        User user = userService.verificationUser("a1b2c3","a1b2c3");
        assertNull(user);
        user = userService.verificationUser("","");
        assertNull(user);
        user = userService.verificationUser("admin","admin");
        assertNotNull(user);
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = userService.getAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(userService);
    }
}