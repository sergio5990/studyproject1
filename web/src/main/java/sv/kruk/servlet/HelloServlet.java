package sv.kruk.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.kruk.domain.User;
import sv.kruk.service.UserService;
import sv.kruk.service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserServiceImp.getInstance();
        User user = userService.checkUser(req.getParameter("username"), req.getParameter("password"));
        if (user != null) {
            logger.info("user sing up, userId = {}", user.getId().toString());
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("tasks");
        }else {
            logger.info("incorrect user, username = {}, password={} ", req.getParameter("username"), req.getParameter("password"));
            req.setAttribute("login_error", "error login or password incorrect");
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "hello page");
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }
}
