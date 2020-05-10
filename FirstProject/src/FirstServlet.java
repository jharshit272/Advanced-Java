import java.io.*;
import javax.servlet.*;


public class FirstServlet implements Servlet{
	ServletConfig config = null;
	//where is the file deployed?
	
	public void init(ServletConfig config){
		this.config = config;
		System.out.println("Initialized your servlet");
	}
	
	public void service(ServletRequest req, ServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<Html><body>");
		out.print("<b>Hello simple servlet! Ready to Start!</b>");
		out.print("</body></Html>");
	}
	
	public void destroy(){
		System.out.println("Servlet is destroyed");
	}
	
	public ServletConfig getServletConfig(){
		return config;
	}
	
	public String getServletInfo(){
		return "Copyright 2007-2016";
	}
}

