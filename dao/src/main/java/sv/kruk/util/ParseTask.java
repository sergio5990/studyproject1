package sv.kruk.util;

import sv.kruk.dao.StatusDao;
import sv.kruk.dao.UserDao;
import sv.kruk.dao.imp.StatusDaoImp;
import sv.kruk.dao.imp.UserDaoImp;
import sv.kruk.domain.Status;
import sv.kruk.domain.Task;
import sv.kruk.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParseTask {
    /**
     * build list tasks of resultset
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static List<Task> getTasksByResultSet(ResultSet resultSet) throws SQLException {
        List<Task> tasks = new ArrayList<Task>();
        UserDao userDao = UserDaoImp.getInstance();
        StatusDao statusDao = StatusDaoImp.getInstance();
        Task task = null;
        while (resultSet.next()) {
            task = new Task();
            task.setId(resultSet.getLong(1));
            User user = userDao.getUserById(resultSet.getLong(8));
            task.setCreateTaskUser(user);
            Status status = statusDao.getStatusById(resultSet.getLong(11));
            task.setStatus(status);
            task.setCreateDate(resultSet.getDate(3));
            task.setDescription(resultSet.getString(4));
            task.setTitle(resultSet.getString(6));
            tasks.add(task);
        }
        return tasks;
    }
}
