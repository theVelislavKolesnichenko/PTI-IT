package bg.tu_varna.sit.petshop.filter;

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
 * Servlet Filter implementation class CoocieFilter
 */
@WebFilter(urlPatterns = "/*")
public class CoocieFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Cookie[] cookies = req.getCookies();
		 
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("cookie_name")) {
					req.setAttribute("cookie", "cookie");
					break;
				}
			}	
		}
		
		chain.doFilter(request, response);
	}


}
