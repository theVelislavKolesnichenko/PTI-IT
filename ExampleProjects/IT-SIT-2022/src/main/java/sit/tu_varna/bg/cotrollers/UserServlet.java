package sit.tu_varna.bg.cotrollers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;
import sit.tu_varna.bg.repositories.Repository;

import java.io.IOException;

@WebServlet(name="ProfileServlet",
        urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    private Repository repository;

    @Override
    public void init() throws ServletException {
        super.init();
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user = username != null
                ? repository.getUserByUsername(new Login(username))
                : (User) request.getSession().getAttribute("user");

        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/public/pages/profile.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
