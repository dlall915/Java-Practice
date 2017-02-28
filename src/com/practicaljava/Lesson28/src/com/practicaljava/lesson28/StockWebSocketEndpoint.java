package com.practicaljava.lesson28;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 * Sends the randomy generated stock prices to all clients every 5 seconds.
 * 
 * @author David Lall
 */

@ServerEndpoint("/stocks")
public class StockWebSocketEndpoint {
	private String[] nasdaqSymbols = {"AAPL","MSFT","YHOO","AMZN","IBM"};
	static ScheduledExecutorService timer = 
			Executors.newSingleThreadScheduledExecutor();
	private static Set<Session> allSessions;
	
	@OnOpen
	public void sendQuotes(Session session) {
		allSessions = session.getOpenSessions();
		// start the scheduler on the very first connection
		// to call sendQuotesToAll every 5 seconds
		timer.scheduleAtFixedRate(
				() -> sendQuotesToAll(session),1,5,TimeUnit.SECONDS);
	}
	
	private void sendQuotesToAll(Session session) {
		allSessions = session.getOpenSessions();
		String price = "";
		StringBuilder quotes = new StringBuilder();
		for (Session sess: allSessions) {
			try {
				for (String symbol : nasdaqSymbols) {
					price = (new Double(Math.random() * 100)).toString();
					quotes.append(symbol);
					quotes.append(" ");
					quotes.append(price);
					quotes.append(System.getProperty("line.separator"));
				}
				sess.getBasicRemote().sendText(quotes.toString());
			}
			catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
}