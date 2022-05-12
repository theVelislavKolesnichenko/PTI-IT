package sit.tu_varna.bg.cotrollers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.tu_varna.bg.models.User;
import sit.tu_varna.bg.repositories.Repository;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "UsersServletName",
        urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Repository repository;

    @Override
    public void init() throws ServletException {
        repository = Repository.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<User> users = repository.getUsers();
        request.setAttribute("users", users);

        RequestDispatcher rd =
                request.getRequestDispatcher("public/pages/user_list.jsp");
        rd.forward(request, response);
    }

}