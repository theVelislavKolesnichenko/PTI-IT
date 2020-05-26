package bg.tu.varna.sit.cotrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bg.tu.varna.sit.beans.JsonResult;
import bg.tu.varna.sit.beans.UserBean;
import bg.tu.varna.sit.repositories.Repository;

@WebServlet(name = "EditUserSkillServletName",
			urlPatterns = "/userskill")
public class EditUserSkillServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;
	private Repository repository;
	
	public void init() throws ServletException {
		repository  = Repository.getInstance();
		gson = new Gson();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
        
        Map<String, String> skill = gson.fromJson(sb.toString(), Map.class);
 
        UserBean newUser = (UserBean) gson.fromJson(sb.toString(), UserBean.class);
        
        UserBean user = repository.getById(newUser.getId()).updateUserSkill(skill);
        repository.update();
        
        JsonResult result = new JsonResult(); 
        if(user != null) {
        	result.setMessage("Записа се");
        } else {
        	result.setMessage("Не се Записа");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(result));
        out.flush();
	}

}
