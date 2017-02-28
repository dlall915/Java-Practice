package com.practicaljava.lesson24;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Server implementation of StockServer. Contains hard coded stock symbols and
 * randomly generated prices.
 * 
 * If the server has to extend some other class, then you can explicitly export
 * it by calling UnicastRemoteObject.export() isntead of extending
 * UnicastRemoteObject.
 * 
 * @author David Lall
 */

public class StockServerImpl extends UnicastRemoteObject 
		implements StockServer { 
	private static final long serialVersionUID = 3652700959797796622L;
	private String price = null;
	private ArrayList<String> nasdaqSymbols = new ArrayList<>();
	public StockServerImpl() throws RemoteException {
		super();
		// define some hard-coded NASDAQ symbols
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
	}
	
	public String getQuote(String symbol) throws RemoteException {
		if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {
			// generate a random price for valid symbols
			price = (new Double(Math.random()*100)).toString();
		}
		return price;
	}
	
	public ArrayList<String> getNasdaqSymbols() throws RemoteException {
		return nasdaqSymbols;
	}
}