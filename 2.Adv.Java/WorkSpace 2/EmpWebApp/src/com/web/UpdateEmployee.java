package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;


@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		Employee emp = new Employee(empId, empName, salary, gender, emailId, password);
		
		EmployeeDAO empDao = new EmployeeDAO();
		int result = empDao.updateEmployee(emp);
		
		if (result > 0) {
			request.getRequestDispatcher("GetAllEmps").forward(request, response);
		} else {
			request.getRequestDispatcher("HRHomePage.jsp").include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Unable to Update the Employee Record!!!</h1>");	
			out.println("</center>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
