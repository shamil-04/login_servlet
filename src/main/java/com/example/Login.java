package com.example;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/login")
//@WebServlet(urlPatterns = "/login", name = "LoginServlet")
//@WebServlet(urlPatterns = "/Welcome", name = "WelcomeServlet")
@WebServlet(urlPatterns = "/login", name = "LoginServlet")
//@WebServlet("/Welcome")	
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out =  response.getWriter();
		String email = request.getParameter("email");
		String pass  = request.getParameter("pass");
		if(Validate.checkUser(email,pass)) {
			RequestDispatcher rs = request.getRequestDispatcher("welcome");
			rs.forward(request, response);
		} else {
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("NewFile1.html");
			rs.include(request, response);
		}
	}

}
