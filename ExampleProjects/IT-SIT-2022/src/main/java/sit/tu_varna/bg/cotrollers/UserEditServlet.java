package sit.tu_varna.bg.cotrollers;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.tu_varna.bg.models.User;
import sit.tu_varna.bg.repositories.Repository;

import java.io.IOException;

@WebServlet(name="UserEditServlet", urlPatterns = {"/user/edit"})
public class UserEditServlet extends HttpServlet {

    private Repository repository;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        repository = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher =
                    //request.getRequestDispatcher("/public/pages/profile_edit.jsp");
                    request.getRequestDispatcher("/public/pages/profile_edit_ajax.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String job = request.getParameter("job");
        String info = request.getParameter("info");

        User newUser = new User(name, job, info, null, null, null, null);
        User sessionUser = (User) request.getSession().getAttribute("user");

        //sessionUser.update(newUser);
        repository.update(sessionUser, newUser);

        response.sendRedirect(String.format("%s/user", request.getContextPath()));
    }
}
