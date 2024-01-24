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


@WebServlet("/GetEmpById")
public class GetEmpById extends HttpServlet {


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int empId = Integer.parseInt(request.getParameter("empId"));

		EmployeeDAO empDao = new EmployeeDAO();
		Employee emp = empDao.getEmployeeById(empId);

		if (emp != null) {

			//Store the emp data under request object
			request.setAttribute("emp", emp);
			
			RequestDispatcher rd = request.getRequestDispatcher("GetEmployeeById.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("HRHomePage.jsp");
			rd.include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Employee Record Not Found!!!</h1>");	
			out.println("</center>");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
