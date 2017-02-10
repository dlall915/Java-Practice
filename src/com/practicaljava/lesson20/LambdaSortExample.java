package com.practicaljava.lesson20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Identical output as SortExample using a lambda expression.
 * Sorted by ascending price, descending price, then by name and price.
 * 
 * @author David Lall
 *
 */

public class LambdaSortExample {
	// populate beer collection
	static List<LambdaBeer> loadCellar() {
		List<LambdaBeer> beerStock = new ArrayList<>();
		beerStock.add(new LambdaBeer("Stella", "Belgium", 7.75f));
		beerStock.add(new LambdaBeer("Sam Adams", "USA", 5.00f));
		beerStock.add(new LambdaBeer("Sam Adams", "USA", 2.00f));
		beerStock.add(new LambdaBeer("Sam Adams", "USA", 12.00f));
		beerStock.add(new LambdaBeer("Sam Adams", "USA", 7.00f));
		beerStock.add(new LambdaBeer("Obolon", "Ukraine", 4.00f));
		beerStock.add(new LambdaBeer("Bud Light", "USA", 5.00f));
		beerStock.add(new LambdaBeer("Yuengling", "USA", 5.50f));
		beerStock.add(new LambdaBeer("Leffe Blonde", "Belgium", 8.75f));
		beerStock.add(new LambdaBeer("Chimay Blue", "Belgium", 10.00f));
		beerStock.add(new LambdaBeer("Brooklyn Lager", "USA", 8.25f));
		beerStock.add(new LambdaBeer("Heady Topper", "USA", 5.50f));
		beerStock.add(new LambdaBeer("King Sue", "USA", 10.00f));
		beerStock.add(new LambdaBeer("Scuba", "USA", 7.00f));
		return beerStock;
	}
	
	public static void main(String[] args) {
		List<LambdaBeer> beers = loadCellar();
		
		// sort by price in ascending order
		System.out.println("=== Sorting by ascending price");
		beers.sort(Comparator.comparing(beer -> beer.price));
		beers.forEach(System.out::println);
		
		System.out.println();
		
		// sort by price in descending order
		Comparator<LambdaBeer> priceComparator = 
				Comparator.comparing(beer -> beer.price);
		System.out.println("=== Sorting by descending price");
		beers.sort(priceComparator.reversed());
		beers.forEach(System.out::println);
		
		System.out.println();
		
		// sort by name and price
		System.out.println("=== Sorting by name and price");
		beers.sort(Comparator.comparing((LambdaBeer beer) -> beer.name)
			.thenComparing(beer -> beer.price));
		beers.forEach(System.out::println);
	}
}