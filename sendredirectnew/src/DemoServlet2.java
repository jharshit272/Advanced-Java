import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try{
			response.setContentType("text/html");
			ServletContext context = getServletContext();
			String n = (String) context.getAttribute("company");
			
			out.println("welcome to "+n);
			out.close();
		}catch(Exception e){
			out.println(e);
		}
	}
}
