package com.practicaljava.lesson15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ClassA {
	public static void main (String[] args) {
		Employee emp = new Employee("John", "Smith");
		emp.setSalary(50000);
		
		try (FileOutputStream fOut = new FileOutputStream("BestEmployee.ser");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);) {
			oOut.writeObject(emp); // serializing employee
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println(
				"Employee object has been serialized into BestEmployee.ser");
	}
}