package com.practicaljava.lesson15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Deserializes a file containing the info for an Employee.
 * 
 * @author David Lall
 *
 */

class ClassB {
	public static void main(String[] args) {
		Employee bestEmp = null;
		try (FileInputStream fileIn = new FileInputStream("BestEmployee.ser");
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
			bestEmp = (Employee)objectIn.readObject();
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("The Employee object has been deserialized");
		System.out.println("First name: " + bestEmp.getFirstName());
		System.out.println("Last name: " + bestEmp.getLastName());
		System.out.println("Salary: " + bestEmp.getSalary());

	}
}