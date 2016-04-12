package sv.kruk.service.imp;

import org.junit.Test;
import sv.kruk.domain.Status;
import sv.kruk.service.StatusService;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StatusServiceImpTest {

    @Test
    public void getAllStatus() throws Exception {
        StatusService statusService = StatusServiceImp.getInstance();
        List<Status> statuses =  statusService.getAllStatus();
        assertNotNull(statuses);
        assertFalse(statuses.isEmpty());
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(StatusServiceImp.getInstance());
    }
}