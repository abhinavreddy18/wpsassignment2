package servletspackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "for Authentication of users;without database", 
		urlPatterns = { "/auth" }, 
		initParams = { 
				@WebInitParam(name = "x", value = "10"), 
				@WebInitParam(name = "y", value = "10")
		})
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AuthenticationServlet() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username1=request.getParameter("username");
		String password1=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		
		MySqlAuthChecker mysql_obj=new MySqlAuthChecker();
		Boolean result=mysql_obj.checkCredentials(username1,password1);
		
		if(result)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/SuccessLoginPage.html");
			rd.forward(request, response);
			
			//if u want to include some data and also html page instead of forward method above use include
			//rd.include();
			
			
		}
		else {
			out.print("<b>Login UnSuccessful");
			
			RequestDispatcher rd=request.getRequestDispatcher("/loginfail.html");
			rd.include(request, response);
			
			
		}
		
		
	}

}
