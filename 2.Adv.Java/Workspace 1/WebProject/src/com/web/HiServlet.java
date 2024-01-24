package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HiServlet")
public class HiServlet extends HttpServlet {

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HiServlet:Init Called..");
}


public void destroy() {
	System.out.println("HiServlet: Destroy servlet Called..");
}
	

       
	
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("HiServlet called...");	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
