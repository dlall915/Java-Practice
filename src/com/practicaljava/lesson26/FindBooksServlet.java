package com.practicaljava.lesson26;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/books", name="FindBooksServlet")
public class FindBooksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// the code processing the request goes here
		// the resulting web page will be sent back via the I/O stream that
		// response variable contains
		PrintWriter out = response.getWriter();
		out.println("Hello from FindBooks");
	}
}