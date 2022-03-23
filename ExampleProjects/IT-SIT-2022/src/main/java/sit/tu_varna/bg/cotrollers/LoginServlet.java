package sit.tu_varna.bg.cotrollers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="LoginServlet",
        urlPatterns = {
                "/login",
                "/index.jsp",
                "/index.html"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/public/pages/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.sendRedirect("/IT_SIT_2022_war_exploded/public/pages/profile.jsp");
//        response.getWriter().append("POST Served at: ")
//                .append(request.getContextPath())
//                .append(username)
//                .append(password);
    }
}
