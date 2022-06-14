package servlets;

import datasource.TaskRepository;
import datasource.UuidRepository;
import helpers.CookieHelper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Task;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TaskServlet", urlPatterns = {"/TaskServlet", "/index.jsp"})
public class TaskServlet extends HttpServlet {
    private TaskRepository taskRepository;
    private UuidRepository uuidRepository;

    @Override
    public void init() throws ServletException {
        taskRepository = TaskRepository.getInstance();
        uuidRepository = UuidRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String message = (String) session.getAttribute("message");
        if (message != null) {
            request.setAttribute("message", message);
            session.invalidate();
        }
        else {
            Cookie cookie = CookieHelper.getCookie(request);
            if (cookie == null) {
                String uuid = uuidRepository.crate();
                session.setAttribute("uuis", uuid);
                Cookie new_cookie = new Cookie("uuid", uuid);
                new_cookie.setMaxAge(new Date().getDate() + 10860);
                response.addCookie(new_cookie);
            }

        }

        request.setAttribute("tasks", taskRepository.getTasks());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tasks.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String date = request.getParameter("day");

        Task task = new Task(title, description, date);
        taskRepository.add(task);

        response.sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
