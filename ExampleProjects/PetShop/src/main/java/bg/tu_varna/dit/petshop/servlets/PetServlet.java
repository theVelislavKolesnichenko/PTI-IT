package bg.tu_varna.dit.petshop.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.tu_varna.sit.petshop.models.Pet;
import bg.tu_varna.sit.petshop.models.Pets;

/**
 * Servlet implementation class PetServlet
 */
@WebServlet(urlPatterns = "/pet")
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Pets pets = (Pets) request.getSession().getAttribute("pets");
		
		Pet pet = pets.get(name);
		
		if(pet != null) {
			request.setAttribute("pet", pet);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		
		Pets pets = (Pets) request.getSession().getAttribute("pets");
		
		Pet pet = new Pet(name);
		pet.setCount(count);
		
		pets.getPet(pet);
		
		response.sendRedirect(request.getContextPath());
		
	}

}
