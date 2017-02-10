package com.practicaljava.lesson20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An example of sorting done with Collection. The Beer class' compareTo() 
 * function was written to compare prices.
 * 
 * @author David Lall
 *
 */
public class SortExample {
	// populate beer collection
	static List<Beer> loadCellar() {
		List<Beer> beerStock = new ArrayList<>();
		beerStock.add(new Beer("Stella", "Belgium", 7.75f));
		beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
		beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
		beerStock.add(new Beer("Bud Light", "USA", 5.00f));
		beerStock.add(new Beer("Yuengling", "USA", 5.50f));
		beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
		beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
		beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));
		return beerStock;
	}
	
	public static void main(String[] args) {
		List<Beer> beers = loadCellar();
		
		Collections.sort(beers);
		beers.forEach(System.out::println);
	}
}