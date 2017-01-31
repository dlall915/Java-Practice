package com.practicaljava.lesson12;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Linked list/thread example using generics.
 * Using raw types should be avoided.
 * 
 * @author David Lall
 *
 */

public class TestLinkedListGenerics {
	public static void main (String[] args) {
		LinkedList <String> passengerList = new LinkedList<>();
		passengerList.add("Alex Smith");
		passengerList.add("Mary Lou");
		passengerList.add("Sim Monk");
		ListIterator<String> iterator = passengerList.listIterator();
		iterator.next();
		iterator.add("VIP Customer");
		for (String passenger : passengerList) {
			System.out.println(passenger);
		}
	}
}