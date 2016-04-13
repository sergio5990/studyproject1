package sv.kruk.dao.imp;

import org.junit.Before;
import org.junit.Test;
import sv.kruk.domain.User;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class UserDaoImpTest {

    private UserDaoImp userDao;

    @Before
    public void setUp() throws Exception {
        userDao = UserDaoImp.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(userDao);
    }

    @Test
    public void getUserById() throws Exception {
        User user = userDao.getUserById(2L);
        assertNotNull(user);
    }

    @Test
    public void getUserByName() throws Exception {
        User user = userDao.getUserByUsername("admin");
        assertNotNull(user);
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = userDao.getAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}