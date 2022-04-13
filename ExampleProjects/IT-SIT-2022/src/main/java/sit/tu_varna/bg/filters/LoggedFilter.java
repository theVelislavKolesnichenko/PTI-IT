package sit.tu_varna.bg.filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sit.tu_varna.bg.models.User;

import java.io.IOException;

@WebFilter(urlPatterns = { "/login", "/register" },
        servletNames = {"LoginServlet", "RegistrationServlet"})
public class LoggedFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            res.sendRedirect(String.format("%s/user", req.getContextPath()));
        } else {
            chain.doFilter(request, response);
       }
    }
}
