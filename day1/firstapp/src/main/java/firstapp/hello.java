package firstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hi")
public class hello extends HttpServlet {

	@Override
	public void init() throws ServletException {
		
		System.out.println("HelloServlet.init() called.");
		
	}
	@Override
	public void destroy() {
		System.out.println("HelloServlet.destroy() called.");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet Request.doGet() called");
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet Request.doPost() called");
		processRequest(req, resp);
	}
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello from HelloServlet</h1>");
		Date now = new Date();
		out.println(now.toString());
		out.println("</body>");
		out.println("</html>");
	}
}
