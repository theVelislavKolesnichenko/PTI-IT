package bg.tu_varna.sit.web_app.modes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class ExtractionFruit
 */
@WebServlet(urlPatterns = "/extractionFruit")
public class ExtractionFruit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson gsun;
	
	public void init() {
		gsun = new Gson();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder builder = new StringBuilder();
		String line;
		while((line = request.getReader().readLine()) != null) {
			builder.append(line);
		}
		
		Fruit fruit = (Fruit) gsun.fromJson(builder.toString(), Fruit.class);
		
		Fruits fruits = (Fruits) request.getSession().getAttribute("fruits");
		
		int count = fruits.extraction(fruit);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(gsun.toJson(count));
		writer.flush();
	}

}
