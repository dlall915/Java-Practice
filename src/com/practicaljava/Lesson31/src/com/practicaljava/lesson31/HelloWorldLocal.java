package com.practicaljava.lesson31;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldLocal
 */
@Stateless
public class HelloWorldLocal implements Authorizable {

	@Override
	public String authorize() {
		return "The user is authorized!";
	}
	
	public String sayHello() {
		return "Hello World!";
	}

}
