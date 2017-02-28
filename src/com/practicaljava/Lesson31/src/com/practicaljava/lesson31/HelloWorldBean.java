package com.practicaljava.lesson31;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * The logic is moved here, away from the Servlet.
 * 
 * LocalBean - no interface-bean
 * Stateless - doesn't remember any data specific to the client
 * Stateful - remembers data, ex. shopping cart
 * Singleton - a place to keep data shared by all the beans
 * 
 * @author David Lall
 */
@LocalBean
@Stateless
public class HelloWorldBean {
	public String sayHello() {
		// you can instantiate and use other POJOs here if need be
		return "Hello World!";
	}
}
