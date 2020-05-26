package bg.tu_varna.dit.petshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bg.tu_varna.sit.petshop.models.Pet;
import bg.tu_varna.sit.petshop.models.Pets;

/**
 * Servlet implementation class GetPetServlet
 */
@WebServlet(name = "GetPetServletName", urlPatterns = "/getpet")
public class GetPetServlet extends HttpServlet {

	private Gson gson;
	
	public void init() {
		gson = new Gson();		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = request.getReader().readLine()) != null) {
			builder.append(line);
		}
		
		Pet pet = (Pet) gson.fromJson(builder.toString(), Pet.class);
		
		Pets pets = (Pets) request.getSession().getAttribute("pets");
		
		int count = pets.getPet(pet);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(gson.toJson(count));
		writer.flush();
	}

}
