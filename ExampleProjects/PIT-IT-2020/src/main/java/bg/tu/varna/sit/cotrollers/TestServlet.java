package bg.tu.varna.sit.cotrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.tu.varna.sit.beans.User;
import bg.tu_varna.sit.services.IUserService;

/**
 * Servlet implementation class TestServlet
 */

//parent -> url1
//child : parent -> url1/url2

@WebServlet(name = "UserTest", urlPatterns = "/testusers")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService service;
	
	//@Inject
	public void TestServlet(IUserService service) {
		this.service = service; 
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		writer.append("Served at: ").append(request.getContextPath());
		List<User> users = service.getUsers();
		writer.append(Arrays.toString(users.toArray()));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
