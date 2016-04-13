package sv.kruk.service;

import sv.kruk.domain.Task;
import sv.kruk.domain.User;

import java.util.List;

/**
 * method for use task
 */
public interface TaskService {

    public  void  save(String title, String description, User user);

    public List<Task> getTasksByUser(User user);

    Task getTaskById(Long taskId, User user);

    void update(Long taskId, Long statusId);
}
