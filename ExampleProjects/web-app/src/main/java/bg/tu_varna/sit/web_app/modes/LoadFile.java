package bg.tu_varna.sit.web_app.modes;

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

import bg.tu_varna.sit.web_app.utility.XmlWorker;

/**
 * Servlet Filter implementation class LoadFile
 */
@WebFilter(servletNames = "FruitServletName", urlPatterns = {"/*", "/index.jsp", "/fruit"})
public class LoadFile implements Filter {
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();

		if(session.getAttribute("fruits") == null) {
			Fruits fruits = new Fruits();
			try {
				
				fruits.add(new XmlWorker().readerFromXmlFile().getAll());
				session.setAttribute("fruits", fruits);
				
			} catch (FileNotFoundException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		chain.doFilter(request, response);
	}
}
