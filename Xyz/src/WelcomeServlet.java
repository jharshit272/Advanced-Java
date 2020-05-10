import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//When I change this to get, why it does not work?
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n=request.getParameter("username");
		out.print("Welcome "+n);
	}
}