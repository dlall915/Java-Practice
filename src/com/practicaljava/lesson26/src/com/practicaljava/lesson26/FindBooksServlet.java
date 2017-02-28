package com.practicaljava.lesson26;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Returns a page that says the entered book costs $65 if you visit the URL
 * http://localhost:8080/Lesson26/books
 * 
 * @author David Lall
 */

@WebServlet(urlPatterns = {"/books"})
public class FindBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindBooksServlet() {}

    // mainly used for data retrieval
    // having HTML embedded inside servlets has many drawbacks
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
			IOException {
		System.out.println("doGet called");
		String title = request.getParameter("booktitle");
		PrintWriter out = response.getWriter();
		// for non text results, this example opens your pdf reader
		//response.setContentType("application/pdf");
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h2>The book "+title+" costs $65.00.");
		out.println("</body></html>");
	}

	// mainly used for sending data to the server
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
			IOException {
	}
}
