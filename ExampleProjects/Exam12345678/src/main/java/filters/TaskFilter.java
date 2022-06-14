package filters;

import datasource.UuidRepository;
import helpers.CookieHelper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "TaskFilter", servletNames = "TaskServlet")
public class TaskFilter implements Filter {

    private UuidRepository uuidRepository;

    public void init(FilterConfig config) throws ServletException {
        uuidRepository = UuidRepository.getInstance();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(true);

        Cookie cookie = CookieHelper.getCookie(httpServletRequest);

        if ("GET".equals(httpServletRequest.getMethod()) || (cookie != null && uuidRepository.exist(cookie.getValue()))) {
            chain.doFilter(request, response);
        }

        String uuid = (String) session.getAttribute("uuid");
        if (cookie == null) {
            if ( uuid != null) {
                uuidRepository.remove(uuid);
                session.removeAttribute("uuid");
            }
            session.setAttribute("message", "message_1");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(String.format("%s/", httpServletRequest.getContextPath()));
        }

        if (cookie != null && !uuidRepository.exist(cookie.getValue())) {
            session.setAttribute("message", "message_2");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(String.format("%s/", httpServletRequest.getContextPath()));
        }
    }
}
