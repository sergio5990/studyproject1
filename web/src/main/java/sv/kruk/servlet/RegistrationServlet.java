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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserServiceImp.getInstance();
        User user =  userService.registrUser(req.getParameter("username"),req.getParameter("password"));
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            logger.info("user register userID={}", user.getId());
            resp.sendRedirect("tasks");
        }else{
            req.setAttribute("error", "Username is invalid");
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("msg", "page registration");
        req.getRequestDispatcher("registration.jsp").forward(req, res);
    }
}
