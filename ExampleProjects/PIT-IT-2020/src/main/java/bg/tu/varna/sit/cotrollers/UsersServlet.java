package bg.tu.varna.sit.cotrollers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.tu.varna.sit.repositories.Repository;

@WebServlet(name = "UsersServletName", 
			urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("public/UserList.jsp");
		rd.forward(request, response);
	}

}
