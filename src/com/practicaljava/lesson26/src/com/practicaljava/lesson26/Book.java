package com.practicaljava.lesson26;

import java.io.Serializable;

/**
 * Each shopping cart item will be represented by this class. It implements
 * Serializable because they'll be kept in the HttpSession object.
 * @author David Lall
 *
 */
class Book implements Serializable {
	String title;
	double price;
}
