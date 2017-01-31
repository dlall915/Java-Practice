package com.practicaljava.lesson11;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Linked list/thread example.
 * 
 * @author David Lall
 *
 */

public class TestLinkedList {
	public static void main (String[] args) {
		LinkedList passengerList = new LinkedList();
		passengerList.add("Alex Smith");
		passengerList.add("Mary Lou");
		passengerList.add("Sim Monk");
		ListIterator iterator = passengerList.listIterator();
		System.out.println(iterator.next());
		iterator.add("VIP Customer");
		// the next line produces a ConcurrentModificationException because
		// it is trying to modify the list while it is being iteratred through
		//passengerList.add("VIP customer");
		iterator.previous();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}
}