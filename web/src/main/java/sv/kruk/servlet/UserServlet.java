package sv.kruk.servlet;

import sv.kruk.domain.User;
import sv.kruk.service.UserService;
import sv.kruk.service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * servlet to view user
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     * servlet for view all users
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserServiceImp.getInstance();
        List<User> users = userService.getAll();
        req.setAttribute("msg", "page users list");
        req.setAttribute("users", users);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}