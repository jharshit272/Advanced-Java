

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
	public void doGet(HttpServletRequest request, HttpServletResponse response){  
		try{  

			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  

			String n=request.getParameter("userName");  
			out.print("Welcome "+n);  

			//creating form that have invisible textfield  
			out.print("<form action='servlet2'>");  
			out.print("<input type='hidden' name='uname' value='"+n+"'>");  
			out.print("<input type='submit' value='go'>");  
			out.print("</form>");  
			out.close();  

		}catch(Exception e){System.out.println(e);}  
	}  
}