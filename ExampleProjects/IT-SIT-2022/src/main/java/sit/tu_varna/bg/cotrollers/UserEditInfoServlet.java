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
import java.io.PrintWriter;

@WebServlet(name = "UserEditInfoServlet", value = "/user/UserEditInfoServlet")
public class UserEditInfoServlet extends HttpServlet {

    private Gson gson;
    private Repository repository;

    public void init() throws ServletException {
        repository  = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = ReaderWorker.read(request.getReader());

        User newUser = gson.fromJson(json, User.class);
        User sessionUser = (User) request.getSession().getAttribute("user");

        JsonResult result = new JsonResult();
        if(sessionUser.update(newUser)) {
            result.setMessage("Записа се");
        } else {
            result.setMessage("Не се Записа");
        }

        response.setContentType("application/json;charset=UTF-8");
        WriterWorker.write(response.getWriter(), gson.toJson(result));
    }
}
