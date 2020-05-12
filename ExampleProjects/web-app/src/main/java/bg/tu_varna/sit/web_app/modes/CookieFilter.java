package bg.tu_varna.sit.web_app.modes;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CookieFilter
 */
@WebFilter(urlPatterns = "/*")
public class CookieFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		for (Cookie cookie : req.getCookies()) {
			if(cookie.getName().equals("cookie_name")) {
				request.setAttribute("cookie", "cookie");
				break;
			}
		} 
		
		chain.doFilter(request, response);
	}

}
