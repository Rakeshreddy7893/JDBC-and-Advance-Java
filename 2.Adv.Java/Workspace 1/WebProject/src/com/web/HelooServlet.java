package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelooServlet
 */
@WebServlet("/HelooServlet")
public class HelooServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelooServlet:Init Called..");
}


public void destroy() {
	System.out.println("HelooServlet: Destroy servlet Called..");
	
}
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet called...");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
