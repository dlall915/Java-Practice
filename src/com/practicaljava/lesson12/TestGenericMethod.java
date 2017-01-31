package com.practicaljava.lesson12;

import java.util.ArrayList;
import com.practicaljava.lesson06.Employee;

/**
 * Example of methods with generic parameters. Prints out a list of type 
 * RetiredEmployee and then creates a copy of type Employee whose contents
 * are also printed to test the generic method.
 * 
 * @author David Lall
 *
 */

public class TestGenericMethod {
	public static void main (String[] args) {
		ArrayList<RetiredEmployee> retiredList = new ArrayList<>();
		retiredList.add(new RetiredEmployee("Gordon Freeman"));
		retiredList.add(new RetiredEmployee("G-Man"));
		retiredList.add(new RetiredEmployee("Alyx"));
		printList(retiredList);
		ArrayList<Employee> employeeList = copyList(retiredList);
		System.out.println("Next lines are a copy of the orignal list: ");
		printList(employeeList);
	}
	
	/**
	 * Takes any ArrayList of type Employee or a subclass of Employee and
	 * returns a new list of type Employee.
	 * 
	 * @param list
	 * 			The ArrayList that is of type Employee or a subclass of it.
	 * @return
	 * 			A new list of type Employee.
	 */
	public static ArrayList<Employee> copyList(ArrayList<? extends Employee> list) {
		ArrayList<Employee> copiedList = new ArrayList<>(list);
		return copiedList;
	}
	
	/**
	 * 
	 * @param list
	 */
	public static void printList(ArrayList<? extends Employee> list) {
		for (Employee employee : list) {
			System.out.println(employee.getName());
		}
	}
}