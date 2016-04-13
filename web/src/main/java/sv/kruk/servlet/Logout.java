package sv.kruk.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.kruk.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    final static private Logger logger = LoggerFactory.getLogger(Logout.class);

    /**
     * servlet for logout user, delete user from session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            logger.info("user logout userId={}", user.getId());
        }
        req.getSession().removeAttribute("user");
        resp.sendRedirect("hello");
    }
}
