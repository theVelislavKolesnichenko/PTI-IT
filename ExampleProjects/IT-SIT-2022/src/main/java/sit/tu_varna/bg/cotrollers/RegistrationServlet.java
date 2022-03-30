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

@WebServlet(name="RegistrationServlet", urlPatterns = { "/register"})
public class RegistrationServlet extends HttpServlet {

    private Repository repository;

    @Override
    public void init() throws ServletException {
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/public/pages/registration.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String compassword = request.getParameter("compassword");

        if(username == null || username.isEmpty() ||
                password == null || password.isEmpty() || !password.equals(compassword)) {
            request.setAttribute("errorMessage", "Невалидни данни за регистрация");
            doGet(request, response);
        } else {
            Login login = new Login(username, password);
            if (!repository.hasExist(login)) {
                repository.addUser(new User(login));
            }
            response.sendRedirect(request.getContextPath());
        }
    }
}
