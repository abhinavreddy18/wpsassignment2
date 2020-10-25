package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rotutingservlet
 */
public class Rotutingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rotutingservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username1=request.getParameter("username");
	String password1=request.getParameter("password");
	sqldbchecker db=new sqldbchecker();
	String name=db.nameSpecify(username1, password1);
		PrintWriter out=response.getWriter();
		if(name!=null) {
			out.print("<p>Common page welcome "+name+"</p>");	
		}
		else {
			out.print("<p>Common page welcome</p>");
		}
		
		
		
	}

}
