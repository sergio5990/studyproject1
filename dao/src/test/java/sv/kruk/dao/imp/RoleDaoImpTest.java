package sv.kruk.dao.imp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RoleDaoImpTest {

    private RoleDaoImp roleDao;

    @Before
    public void setUp() throws Exception {
        roleDao = RoleDaoImp.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(roleDao);
    }
}