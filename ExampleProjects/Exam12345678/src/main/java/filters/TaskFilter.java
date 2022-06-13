package filters;

import datasource.UuidRepository;
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

        Cookie cookies[] = httpServletRequest.getCookies();
        Cookie cookie = null;
        for (Cookie item : cookies) {
            if ("uuid".equals(item.getName())) {
                cookie = item;
                break;
            }
        }

        if (cookie == null || (cookie != null && cookie.getMaxAge() > 0 && uuidRepository.exist(cookie.getValue()))) {
            chain.doFilter(request, response);
        }

        if (cookie != null && cookie.getMaxAge() < 0) {
            uuidRepository.remove(cookie.getValue());
            session.setAttribute("message", "message_1");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(String.format("%s/", httpServletRequest.getContextPath()));
        }

        if (cookie != null && cookie.getMaxAge() > 0 && !uuidRepository.exist(cookie.getValue())) {
            session.setAttribute("message", "message_2");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(String.format("%s/", httpServletRequest.getContextPath()));
        }
    }
}
