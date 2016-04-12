package sv.kruk.servlet;

import sv.kruk.domain.Task;
import sv.kruk.domain.User;
import sv.kruk.service.TaskService;
import sv.kruk.service.imp.TaskServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TasksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = TaskServiceImp.getInstance();
        taskService.save(req.getParameter("title"), req.getParameter("description"), (User)req.getSession().getAttribute("user"));
        List<Task> tasks = taskService.getTasksByUser((User)req.getSession().getAttribute("user"));
        if (tasks != null) {
            req.setAttribute("tasks", tasks);
        }
        req.setAttribute("msg", "page for tasks");
        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = TaskServiceImp.getInstance();
        List<Task> tasks = taskService.getTasksByUser((User)req.getSession().getAttribute("user"));
        if (tasks != null) {
            req.setAttribute("tasks",tasks);
        }
            req.setAttribute("msg", "page for tasks");
            req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }
}
