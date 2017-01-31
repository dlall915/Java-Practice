package com.practicaljava.lesson13;

import java.util.ArrayList;
import java.util.List;

/**
 * An example showing the difference between imperative and functional 
 * programming when searching a list.
 * 
 * Imperative - we tell Java how to do things.
 * Functional - we tell Java what we want to do.
 * 
 * contains() is part of ArrayList. Another argument for the functional style 
 * is if improvements are made to contains() in future versions of Java. The 
 * function could be changed to do parallel searching, while the imperative
 * style will always search sequential.
 * 
 * @author David Lall
 *
 */

public class ImperativeVsFunctional {
	public static void main (String[] args) {
		
		List<String> winners = new ArrayList<>();
		
		winners.add("Mary");
		winners.add("Ringo");
		winners.add("Joe");
		winners.add("Paul");
		
		// Imperative style
		boolean gotRingo = false;
		for (String winner : winners) {
			if ("Ringo".equals(winner)) {
				gotRingo = true;
				System.out.println("Imperative style. Ringo won? " + gotRingo);
				break;
			}
		}
		
		// Functional style
		System.out.println("Functional style. Ringo won? " + 
				winners.contains("Ringo"));
	}
}