package bg.tu_varna.sit.vegetables_webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/vegetables")
public class VegetablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Vegetables vegetables;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		HashSet<Vegetable> vHashSet = new HashSet<Vegetable>();
		vHashSet.add(new Vegetable("Vegetable 1", 1, 1));
		vHashSet.add(new Vegetable("Vegetable 2", 2, 2));
		vHashSet.add(new Vegetable("Vegetable 3", 3, 3));
		
		this.vegetables = new Vegetables();
		this.vegetables.setVegetables(vHashSet);
		
		XMLWOrker.writer(vegetables);
		
		gson = new Gson();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("vegetables", vegetables);

		RequestDispatcher rd = request.getRequestDispatcher("vegetables.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = request.getReader().readLine()) != null) {
			stringBuilder.append(line);
		}
		
		Vegetable vegetable = (Vegetable) gson.fromJson(stringBuilder.toString(), Vegetable.class);
	
		int count = vegetables.getVegetable(vegetable);
		XMLWOrker.writer(vegetables);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(gson.toJson(count));
		writer.flush();
	}

}
