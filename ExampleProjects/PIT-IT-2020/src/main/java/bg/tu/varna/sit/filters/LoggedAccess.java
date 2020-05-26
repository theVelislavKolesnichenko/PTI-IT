package bg.tu.varna.sit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.tu.varna.sit.beans.UserBean;

@WebFilter(servletNames = { "UserServletName" })
public class LoggedAccess implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //http://localhost:8080/PIT-IT-2020/user?id=1&action=edit
        int id = Integer.parseInt(req.getParameter("id"));
        String action = request.getParameter("action");
        
        HttpSession session = req.getSession(false);
        UserBean sessionUser = (session != null) 
        		? (UserBean)session.getAttribute("user")
        		: null;
        		
        if (sessionUser == null) {
            res.sendRedirect(req.getContextPath());
        } else if(id != sessionUser.getId() && action != null && !action.isEmpty() && action.equals("edit")) {
        	res.sendRedirect("user?id=" + sessionUser.getId());
        } else {
            chain.doFilter(request, response);
        }
	}

}
