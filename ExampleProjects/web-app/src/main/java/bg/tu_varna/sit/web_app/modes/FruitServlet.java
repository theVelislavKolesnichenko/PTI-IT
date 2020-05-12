package bg.tu_varna.sit.web_app.modes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FruitServlet
 */
@WebServlet(name = "FruitServletName", urlPatterns = "/fruit")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		Fruits fruits = (Fruits) req.getSession().getAttribute("fruits");
		
		Fruit fruit = fruits.get(name);
		
		if(fruit == null) {
			resp.sendRedirect(req.getContextPath());
		} else {
			req.setAttribute("fruit", fruit);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/fruit.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		
		Fruits fruits = (Fruits) request.getSession().getAttribute("fruits");
		
		Fruit fruit = new Fruit(name);
		fruit.setCount(count);
		
		fruits.extraction(fruit);

		response.sendRedirect(request.getContextPath());
		
	}

}
