package sv.kruk.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(Logout.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("user logout userId={}", req.getSession().getAttribute("user"));
        req.getSession().removeAttribute("user");
        resp.sendRedirect("hello");
    }
}
