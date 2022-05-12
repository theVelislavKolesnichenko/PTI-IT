package sit.tu_varna.bg.cotrollers;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.tu_varna.bg.helpers.ReaderWorker;
import sit.tu_varna.bg.helpers.WriterWorker;
import sit.tu_varna.bg.models.JsonResult;
import sit.tu_varna.bg.models.User;
import sit.tu_varna.bg.repositories.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserEditUserSkillServlet", value = "/user/UserEditUserSkillServlet")
public class UserEditUserSkillServlet extends HttpServlet {

    private Gson gson;
    private Repository repository;

    public void init() throws ServletException {
        repository  = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String json = ReaderWorker.read(request.getReader());

        Map<String, String> requestSkills = gson.fromJson(json, Map.class);
        Map<String, Short> skills = convert(requestSkills);
        User sessionUser = (User) request.getSession().getAttribute("user");

        JsonResult result = new JsonResult();
        if(sessionUser.update(skills)) {
            result.setMessage("Записа се");
        } else {
            result.setMessage("Не се Записа");
        }

        response.setContentType("application/json;charset=UTF-8");
        WriterWorker.write(response.getWriter(), gson.toJson(result));
    }

    private Map<String, Short> convert(Map<String, String> requestSkills) {
        Map<String, Short> result = new HashMap<>();
        for (Map.Entry<String, String> entry : requestSkills.entrySet()) {
            result.put(entry.getKey(), Short.valueOf(entry.getValue()));
        }
        return result;
    }
}
