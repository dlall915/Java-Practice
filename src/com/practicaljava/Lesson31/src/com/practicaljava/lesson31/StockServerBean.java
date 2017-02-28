package com.practicaljava.lesson31;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class StockServerBean {
    private String price = null;
    private List<String> nasdaqSymbols = new ArrayList<>();
    public StockServerBean() {
    	// define some hard-coded NASDAQ symbols
    	nasdaqSymbols.add("AAPL");
    	nasdaqSymbols.add("MSFT");
    	nasdaqSymbols.add("YHOO");
    	nasdaqSymbols.add("AMZN");    		
    }
    	
    @Schedule(second="*")
    public void getQuote(String symbol) {
    	if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
    		// generate a random price for valid symbols
    		price = (new Double(Math.random()*100)).toString();
    	}
    	System.out.println("The price of " + symbol + "is " + price);
    }
}
