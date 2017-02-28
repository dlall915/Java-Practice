package com.practicaljava.lesson27;

import java.io.Serializable;

/**
 * Java bean, usually protects it's fields with getters and setters. has a
 * no argument constructor, and implements Serializable.
 * 
 * @author David Lall
 */
public class Stock implements Serializable {
	private static final long serialVersionUID = -7439425792602985244L;
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
