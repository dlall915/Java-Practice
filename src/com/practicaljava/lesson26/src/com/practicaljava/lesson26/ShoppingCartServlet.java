package com.practicaljava.lesson26;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Shopping cart example. HttpSession is used to store the books to user adds
 * to the cart. The cart is set to reset in 60 seconds.
 * @author David Lall
 *
 */

@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
			IOException {
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (int i=0; i < cookies.length; i++) {
				Cookie currentCookie = cookies[i];
				String name = currentCookie.getName();
				String value = currentCookie.getValue();
			
				System.out.println("Recieved the cookie " + name + "=" + value);
			}
		}
		
		// get or create a session object
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60);
		
		// try to get the shoping cart
		ArrayList<Book> myShoppingCart=(ArrayList<Book>)
				session.getAttribute("shoppingCart");
		if(myShoppingCart == null) {
			// this is the first call - instantiate the shopping cart
			myShoppingCart = new ArrayList<>();
		}
		
		// create an instance of a book object for received params
		Book selectedBook = new Book();
		selectedBook.title = request.getParameter("booktitle");
		selectedBook.price = Double.parseDouble(request.getParameter("price"));
		
		// add the book to our shopping cart
		myShoppingCart.add(selectedBook);
		
		// put the shopping cart back into the session object
		session.setAttribute("shoppingCart", myShoppingCart);
		
		// prepare the Web page and send it to the browser
		PrintWriter out = response.getWriter();
		
		// add the content of the shopping cart to the Web page
		out.println("<body>Your shopping cart content:");
		myShoppingCart.forEach(book -> out.printf("<br>Title: %s, price: %.2f",
				book.title, book.price)
		);
		
		// add the HTML form to the Web page
		out.println("<p>Add another book to the shopping cart:");
		out.println("<form action=shoppingcart method=Get>");
		out.println("<input type=Text name=booktitle>");
		out.println("<input type=Text name=price>");
		out.println(
		"<input type=Submit value='Add to shopping cart'>");
		out.println("<input type=Submit name=placeorder value='Place Order'>");
		out.println("</form>");
		out.println("</body>");
	}
}
