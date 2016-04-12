package sv.kruk.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        servletResponse.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
