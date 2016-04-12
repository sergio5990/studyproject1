package sv.kruk.dao.imp;

import org.junit.Before;
import org.junit.Test;
import sv.kruk.domain.Task;
import sv.kruk.domain.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TaskDaoImpTest {

    private TaskDaoImp taskDao;
    private User user;

    @Before
    public void setUp() throws Exception {
        taskDao =TaskDaoImp.getInstance();
        user = UserDaoImp.getInstance().getUserById(3L);
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(taskDao);
    }

    @Test
    public void getTasksByUser() throws Exception {
        List<Task> tasks = taskDao.getTasksByUser(user);
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
    }

    @Test
    public void getTaskById() throws Exception {
        Task task = taskDao.getTaskById(27L);
        assertNotNull(task);
        assertEquals(user, task.getCreateTaskUser());

    }
}