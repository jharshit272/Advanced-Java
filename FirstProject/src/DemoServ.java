//Put the files in different package and then do

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServ extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
			{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();

		String name=req.getParameter("name");
		String clg=req.getParameter("clg");
		String company=req.getParameter("company");
		pw.println("Welcome "+name);
		pw.println("Your clg is "+clg+" and company is "+company);
		pw.println("Hello in servlet");

		pw.close();
			}
} 
