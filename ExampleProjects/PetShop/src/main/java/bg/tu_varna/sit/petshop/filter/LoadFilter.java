package bg.tu_varna.sit.petshop.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import bg.tu_varna.sit.petshop.models.Pets;
import bg.tu_varna.sit.petshop.utility.XmlWorker;

/**
 * Servlet Filter implementation class LoadFilter
 */
@WebFilter(servletNames = "", urlPatterns = "/*")
public class LoadFilter implements Filter {

  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("pets") == null) {
			Pets pets = new Pets();	
			XmlWorker worker = new XmlWorker();
			try {
				pets.add(worker.readerFromXmlFile().getPets());
				session.setAttribute("pets", pets);
			} catch (FileNotFoundException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		chain.doFilter(request, response);
	}

}
