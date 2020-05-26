package bg.tu.varna.sit.cotrollers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.tu.varna.sit.beans.SkillBeen;
import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.repositories.Repository;

@WebServlet(name = "RegistrationServletName", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository users;
	
	public void init() throws ServletException {
		users  = Repository.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/public/RegistrationPage.jsp");
		 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String compassword = request.getParameter("compassword");
		
		if(username == null || username.isEmpty() || password == null || password.isEmpty() || !compassword.equals(password))
		{
			response.sendRedirect(request.getContextPath());
		}
		else {
			UserBean user = new UserBean(username, password);
			ArrayList<SkillBeen> sills = new ArrayList<SkillBeen>();
			sills.add(new SkillBeen());
			sills.add(new SkillBeen());
			sills.add(new SkillBeen());
			
			user.setPersonSkills(sills);
			
			sills.add(new SkillBeen());
			user.setJobsSkills(sills);
			
			if(users.hasExist(user)) {
				response.sendRedirect(request.getContextPath());
			} else {
				users.addUser(user);				
				response.sendRedirect(request.getContextPath());
			}		
		}

	}

}
