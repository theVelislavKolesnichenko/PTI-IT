package bg.tu_varna.sit.web;

import bg.tu_varna.sit.utilites.HttpWorker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

@WebServlet("/")
public class ShowAllTasksServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpWorker.writeBody(resp.getWriter(), getRepository().all());
        } catch (JAXBException e) {
            resp.setStatus(400);
        }
    }
}
