package sv.kruk.filter;

import sv.kruk.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SingInFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpSession session = httpReq.getSession();
        User user = (User) session.getAttribute("user");
        String path =  httpReq.getContextPath();
        if (!httpReq.getRequestURI().equals(path + "/404") && !httpReq.getRequestURI().equals(path + "/")
                && !httpReq.getRequestURI().equals(path + "/registration") && !httpReq.getRequestURI().equals(path + "/hello")
                && !httpReq.getRequestURI().equals(path + "/logout") ) {
            if (user == null) {
                httpReq.getRequestDispatcher("registration").forward(req, resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
