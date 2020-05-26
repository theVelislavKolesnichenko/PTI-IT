package bg.tu.varna.sit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.tu.varna.sit.beans.UserBean;

@WebFilter(servletNames = {"LoginServletName", "RegistrationServletName"})
public class AnonymousAccess implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        UserBean sessionUser = (session != null) 
        		? (UserBean)session.getAttribute("user")
        		: null;
        		
        if (sessionUser != null) {
            res.sendRedirect("user?id=" + sessionUser.getId());
        } else {
            chain.doFilter(request, response);
        }
	}
}
