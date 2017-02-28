package com.practicaljava.lesson27;

import java.util.ArrayList;

public class StockPriceGenerator {
	private ArrayList<String> nasdaqSymbols = new ArrayList<>();
	
	public StockPriceGenerator() {
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
		nasdaqSymbols.add("IBM");
	}
	
	public String getPrice(String symbol) {
		String price = "";
        
		// Check if the symbol is valid 
		if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
			// Generate a random price for valid symbols
			price = (new Double(Math.random() * 100)).toString();
		} else {
			price = "Not a valid symbol.Use one of these: " +
		                              getSupportedSymbols();
		}

		return price;
	}
	
	private String getSupportedSymbols() {
		StringBuilder symbols = new StringBuilder();
		for (String symbolName : nasdaqSymbols) {
			symbols.append(symbolName);
			symbols.append(" ");
		}
		return symbols.toString();
	}
}
