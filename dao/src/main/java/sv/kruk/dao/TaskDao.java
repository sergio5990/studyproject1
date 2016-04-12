package sv.kruk.dao;

import sv.kruk.domain.Task;
import sv.kruk.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    List<Task> getTasksByUser(User user) throws SQLException;

    void save(Task task) throws SQLException;

    Task getTaskById(Long taskId) throws SQLException;

    void updateStatus(Long taskId, Long statusId);
}
