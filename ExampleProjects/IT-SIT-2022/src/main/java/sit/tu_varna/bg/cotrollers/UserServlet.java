package sit.tu_varna.bg.cotrollers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.tu_varna.bg.helpers.CookiesWorker;
import sit.tu_varna.bg.models.Login;
import sit.tu_varna.bg.models.User;
import sit.tu_varna.bg.repositories.Repository;

import java.io.IOException;

@WebServlet(name="ProfileServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    private Repository repository;

    @Override
    public void init() throws ServletException {
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
            request.setAttribute("message", hasDisplayWelcomeMessage(request, user));

            RequestDispatcher requestDispatcher =
            request.getRequestDispatcher("/public/pages/profile.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private Object hasDisplayWelcomeMessage(HttpServletRequest request, User user) {
        Cookie cookie = CookiesWorker.getWelcomeCookie(request);
        return !(cookie != null && cookie.getValue().contains(user.getLogin().getUsername()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
