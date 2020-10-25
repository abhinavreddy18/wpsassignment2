package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class authentify
 */
public class authentify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentify() {
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
		System.out.println(username1);
		PrintWriter out=response.getWriter();
		boolean result=db.checkCredentials(username1, password1);
		if(result) {
			out.print("<p>welcome Mr "+username1+" we are pleased to offer you service</p>");	
			RequestDispatcher rd=request.getRequestDispatcher("/SuccessLoginPage.html");
			rd.forward(request, response);
		}
		else {

			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		
		
		
		
	}


}
