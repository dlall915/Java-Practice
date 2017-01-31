package com.practicaljava.lesson15;

/**
 * Example using serialization.
 * The keyword transient will prevent a field from being serialized.
 * 
 * @author David Lall
 *
 */

public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1554132505890105825L;
	private String firstName;
	private String lastName;
	private double salary;
	
	Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}