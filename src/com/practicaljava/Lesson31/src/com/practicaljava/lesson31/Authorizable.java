package com.practicaljava.lesson31;

import javax.ejb.Local;

/**
 * Local - exposes method to local clients
 * 
 * @author David Lall
 */

@Local
public interface Authorizable {
	public String authorize();
}
