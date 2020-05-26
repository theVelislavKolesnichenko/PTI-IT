package bg.tu_varna.dit.petshop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoocieServlet
 */
@WebServlet(urlPatterns = "/coocie")
public class CoocieServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("cookie_name", "cookie_value");
		cookie.setMaxAge(5);
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath());
	}

}
