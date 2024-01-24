package com.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.dto.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String emailId = request.getParameter("emailId");
			String password = request.getParameter("password");
			
			//Session object to store emailId
			HttpSession session = request.getSession(true);
			session.setAttribute("emailId", emailId);
			
			out.println("<html>");
			if (emailId.equalsIgnoreCase("HR") && password.equals("HR")) {			
				
				RequestDispatcher rd = request.getRequestDispatcher("HRHomePage.jsp");
				rd.forward(request, response);
				
			} else {			
				
				
				EmployeeDAO empDao = new EmployeeDAO();
				Employee emp = empDao.empLogin(emailId, password);
				
				if (emp != null) {

				    //Store Employee information(Object) under Session
				    session.setAttribute("emp", emp);
								
				    RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
				    rd.forward(request, response);
								
				} 
         else {
					out.println("<body bgcolor='lightyellow' text='red'>");
					out.println("<center>");
					out.println("<h1>Invalid Credentials</h1>");
					
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
				
				
			}
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
			
		}

		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
