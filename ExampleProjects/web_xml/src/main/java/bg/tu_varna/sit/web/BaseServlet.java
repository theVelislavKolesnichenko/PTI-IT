package bg.tu_varna.sit.web;

import bg.tu_varna.sit.repositories.TaskRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
    private TaskRepository repository;

    @Override
    public void init() throws ServletException {
        this.repository = TaskRepository.getInstance();
    }

    protected TaskRepository getRepository() {
        return repository;
    }
}
