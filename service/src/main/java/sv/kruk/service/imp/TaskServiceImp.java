package sv.kruk.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.kruk.dao.StatusDao;
import sv.kruk.dao.TaskDao;
import sv.kruk.dao.imp.StatusDaoImp;
import sv.kruk.dao.imp.TaskDaoImp;
import sv.kruk.domain.Task;
import sv.kruk.domain.User;
import sv.kruk.service.TaskService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TaskServiceImp implements TaskService {
    final static Logger logger = LoggerFactory.getLogger(TaskServiceImp.class);

    private static volatile TaskServiceImp instance;

    private TaskServiceImp(){}

    public static TaskServiceImp getInstance(){
        if (instance == null) {
            synchronized (TaskServiceImp.class){
                if (instance == null) {
                    instance = new TaskServiceImp();
                }
            }
        }
        return  instance;
    }

    public void save(String title, String description, User user) {
        if (title != null && !title.equals("")) {
            Task task = new Task(title, description);
            task.setCreateDate(new Date());
            task.setCreateTaskUser(user);
            StatusDao statusDao = StatusDaoImp.getInstance();
            try {
                task.setStatus(statusDao.getStatusByName("OPEN"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            TaskDao taskDao = TaskDaoImp.getInstance();
            try {
                taskDao.save(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Task> getTasksByUser(User user) {
        logger.info("tasks find by userId={}", user.getId());
        TaskDao taskDao = TaskDaoImp.getInstance();
        List<Task> tasks = null;
        try {
            tasks = taskDao.getTasksByUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task getTaskById(Long taskId, User user) {
        TaskDao taskDao =TaskDaoImp.getInstance();
        Task task = null;
        try {
            task = taskDao.getTaskById(taskId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (task == null || !task.getCreateTaskUser().equals(user)) {
            return null;
        }
        return task;
    }

    public void updateStatus(Long taskId, Long statusId) {
        TaskDao taskDao =TaskDaoImp.getInstance();
        taskDao.updateStatus(taskId, statusId);
    }
}
