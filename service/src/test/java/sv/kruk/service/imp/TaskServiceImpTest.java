package sv.kruk.service.imp;

import org.junit.Before;
import org.junit.Test;
import sv.kruk.domain.Task;
import sv.kruk.domain.User;
import sv.kruk.service.TaskService;
import sv.kruk.service.UserService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class TaskServiceImpTest {

    private  TaskService taskService;
    private  UserService userService;
    private User user;

    @Before
    public void setUp() throws Exception {
        taskService = TaskServiceImp.getInstance();
        userService = UserServiceImp.getInstance();
        user = userService.getAll().get(2);
    }

    @Test
    public void getTasksByUser() throws Exception {
        List<Task> tasks = taskService.getTasksByUser(user);
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
    }

    @Test
    public void getTaskById() throws Exception {
        Task task = taskService.getTaskById(27L, user);
        assertNotNull(task);
        assertEquals(user, task.getCreateTaskUser());
    }


    @Test
    public void getInstance() throws Exception {
        assertNotNull(taskService);
    }
}