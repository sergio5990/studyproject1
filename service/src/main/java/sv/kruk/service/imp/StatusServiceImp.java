package sv.kruk.service.imp;

import sv.kruk.dao.StatusDao;
import sv.kruk.dao.imp.StatusDaoImp;
import sv.kruk.domain.Status;
import sv.kruk.service.StatusService;

import java.sql.SQLException;
import java.util.List;

public class StatusServiceImp implements StatusService {
    private static volatile StatusServiceImp instance;

    private StatusServiceImp(){}
    /**
     * singleton
     * @return
     */
    public static StatusServiceImp getInstance(){
        if (instance == null) {
            synchronized (StatusServiceImp.class){
                if (instance == null) {
                    instance = new StatusServiceImp();
                }
            }
        }
        return  instance;
    }

    /**
     * return list status
     * @return
     */
    public List<Status> getAll() {
        StatusDao statusDao =  StatusDaoImp.getInstance();
        List<Status> statusList = null;
        try {
            statusList = statusDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusList;
    }
}
