package com.practicaljava.lesson20;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Two ways of going through a list of beers and getting the average price of
 * the American ones. The first way goes through each step, and the last is a
 * condensed version. The intermediate operations will not trigger unless the
 * terminal operation is invoked. Streams are immutable*
 * 
 * Processing may be done in parallel.
 * 
 * @author David Lall
 *
 */

public class LazyStreamsDemo {
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
		
		// first intermediate operation
		Stream<Beer> americanBeers = beers.stream().filter(brrsssss -> {
			System.out.println("Inside filter: " + brrsssss.country);
			return "USA".equals(brrsssss.country);
		});
		
		// second intermediate operation
		DoubleStream americanBeerPrices = americanBeers.mapToDouble(brrr -> {
			System.out.println("Inside mapToDouble: " + brrr.name +
					": " + brrr.price);
			return brrr.price;
		});
		
		// terminal operation
		System.out.println("The average American beer price is $" +
				americanBeerPrices.average().getAsDouble());
		
		// condensed version
		OptionalDouble averagePrice = beers.stream()
				.filter(brr -> "USA".equals(brr.country))
				.mapToDouble(brrr -> brrr.price)
				.average();
		
		System.out.println("The average American beer price is $" +
				averagePrice.getAsDouble());
	}
}