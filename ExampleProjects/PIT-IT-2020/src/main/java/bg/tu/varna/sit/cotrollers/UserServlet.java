package bg.tu.varna.sit.cotrollers;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.tu.varna.sit.beans.JsonResult;
import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.repositories.Repository;

@WebServlet(
		name = "UserServletName",
		urlPatterns = "/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;
	
	private Repository repository;
	public void init() throws ServletException {
		repository  = Repository.getInstance();
		gson = new Gson();
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
	      resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
	      resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
	      }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		
		String page = (action != null && !action.isEmpty() && action.equals("edit")) 
						? "private/EditProfilePage.jsp"
						: "public/ProfilePage.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Cookie cookies[] = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("message1")) {
				request.setAttribute("message", cookie.getName());
				break;
			}
		}
		
		HttpSession oldSession = request.getSession(false);
        UserBean sessionUser = (oldSession != null) 
        		? (UserBean)oldSession.getAttribute("user")
        		: null;
		
		if(sessionUser == null || sessionUser.getId() != id) {
			sessionUser = repository.getById(id);
		}
        		
		request.setAttribute("user", sessionUser);
        		
        //if((sessionUser != null) ) {
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
    		requestDispatcher.forward(request, response);
        //}
        //else {
        	// response.sendRedirect("/PIT-IT-2020");
        //}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setAccessControlHeaders(response);
		request.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
 
        UserBean newUser = (UserBean) gson.fromJson(sb.toString(), UserBean.class);
        
        UserBean user = repository.getById(newUser.getId()).updateUserInfo(newUser);
        repository.update();
        //String jsonUser = gson.toJson(user);
        
        JsonResult result = new JsonResult(); 
        if(user != null) {
        	result.setMessage("Записа се");
        } else {
        	result.setMessage("Не се Записа");
        }
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(result));
        out.flush();
		
		/*int id = Integer.parseInt(request.getParameter("id"));
		final String name = request.getParameter("name");
		final String jobTitle = request.getParameter("jobTitle");
		final String info = request.getParameter("info");
		
		String skill1Name = request.getParameter("nameSkill0");
		String skill1Value = request.getParameter("valueSkill0");
		
		String action = request.getParameter("action");
		
		UserBean newUser = new UserBean() {
			{
				setName(name);
				setJobTitle(jobTitle);
				setInfo(info);
			}
		};*/
		
		//UserBean user = repository.getById(id).update(newUser);
	
		//request.setAttribute("user", user);
		
		//String page = "private/EditProfilePage.jsp";
		
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		//requestDispatcher.forward(request, response);
	}
}
