package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;

@WebServlet("/GetAllEmps")
public class GetAllEmps extends HttpServlet {

       
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO empDao = new EmployeeDAO();		
		List<Employee> empList = empDao.getAllEmployees();
		
		if (empList != null) {
			
			//Storing employees list under request object
			request.setAttribute("empList", empList);
			
			RequestDispatcher rd = request.getRequestDispatcher("GetAllEmps.jsp");
			rd.forward(request, response);			
		
		} else {	
			
			RequestDispatcher rd = request.getRequestDispatcher("HRHomePage.jsp");
			rd.include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Unable to Fetch the Employee Record(s)!!!</h1>");	
			out.println("</center>");
		}
}
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
