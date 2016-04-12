package sv.kruk.dao.imp;

import org.junit.Before;
import org.junit.Test;
import sv.kruk.domain.Status;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StatusDaoImpTest {

    private StatusDaoImp statusDao;

    @Before
    public void setUp() throws Exception {
        statusDao = StatusDaoImp.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(statusDao);
    }

    @Test
    public void getStatusById() throws Exception {
        Status status = statusDao.getStatusById(2L);
        assertNotNull(status);
        assertNotNull(status.getName());
    }

    @Test
    public void getStatusByName() throws Exception {
        Status status = statusDao.getStatusByName("OPEN");
        assertNotNull(status);
        assertEquals("OPEN", status.getName());
    }

    @Test
    public void getAll() throws Exception {
        List<Status> statuses = statusDao.getAll();
        assertNotNull(statuses);
        assertFalse(statuses.isEmpty());
    }
}