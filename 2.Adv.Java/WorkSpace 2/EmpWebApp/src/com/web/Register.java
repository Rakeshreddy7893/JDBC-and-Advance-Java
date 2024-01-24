package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;


@WebServlet("/Register")
public class Register extends HttpServlet {

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String empName = request.getParameter("empName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		Employee emp = new Employee(0, empName, salary, gender, emailId, password);
		
		EmployeeDAO empDao = new EmployeeDAO();
		int result = empDao.registerEmployee(emp);
		
		out.println("<center>");
		
		if (result > 0) {			
			out.println("<h1 style='color:green;'>Employee Registered Successfully!!!</h1> <br/>");
					
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		} else {			
			
			RequestDispatcher rd = request.getRequestDispatcher("Register.html");
			rd.include(request, response);
			
			out.println("<h1 style='color:red;'>Unable Register the Employee Recored!!!</h1>");
		}
		out.println("<center>");
	}
    
    
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}