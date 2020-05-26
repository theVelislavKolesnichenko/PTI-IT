package bg.tu.varna.sit.cotrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.repositories.Repository;

import static bg.tu.varna.sit.utility.constants.JSPFilePaths.LoginSuccess;
import static bg.tu.varna.sit.utility.constants.RequestParameters.Password;
import static bg.tu.varna.sit.utility.constants.RequestParameters.Username;

@WebServlet(name = "LoginServletName", 
			urlPatterns = {"/index.html", "/LoginServlet", "/index.jsp"})
public class LoginServlet extends HttpServlet {
    
	Repository users;
	
	public void init() throws ServletException {
		users = Repository.getInstance();
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("/public/login.jsp");
		 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 
        // get request parameters for username and password
        UserBean userBeen = new UserBean(request.getParameter("username"), 
        								 request.getParameter("password"));
        if (users.hasExist(userBeen)) {
        	UserBean user = users.getUserByUsername(userBeen.getUsername());
        	
        	HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
        	HttpSession newSession = request.getSession(true);
        	newSession.setAttribute("user", user);
        	//user?id=1&action=edit
        	response.sendRedirect("user?id=" + user.getId() + "&action=edit");
         
        } else {
        	response.sendRedirect(request.getContextPath());
        }
    }
} 
