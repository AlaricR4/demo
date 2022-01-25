package fr.formation.inti.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginS
 */
@WebServlet("/login")
public class loginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginS() {
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
	
		String login = request.getParameter("Login");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date = dtf.format(LocalDateTime.now()).toString();

		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Login</title></head>");
		out.println("<body>");
		out.println("<p>hello "+login+"</p>");
		out.println("<p>you are connected</p>");
		out.println("<p>"+date+"</p>");
		
		out.println("<form action=\"index.html\" method=\"post\">"		
				+ "<input type=\"submit\" value=\"Retour home\">"		
				+ "</form>");

}

}
