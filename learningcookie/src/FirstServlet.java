

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n= request.getParameter("userName");
			out.print("Welcome "+n);

			Cookie ck=new Cookie("uname", n);
			response.addCookie(ck);

			out.print("<form action='servlet2'>");
			out.print("<input type = 'submit' 'value='go'>");
			out.print("</form>");

			out.close();
		}catch(Exception e){System.out.println(e);
		}
	}
}