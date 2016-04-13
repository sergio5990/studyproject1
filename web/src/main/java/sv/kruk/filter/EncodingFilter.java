package sv.kruk.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    /**
     * filter set only utf-8 encoding
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        servletResponse.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
