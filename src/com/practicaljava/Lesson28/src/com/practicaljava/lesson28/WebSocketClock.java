package com.practicaljava.lesson28;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 * Sends the server time to all clients every second.
 * 
 * @author David Lall
 */

@ServerEndpoint("/clock")
public class WebSocketClock {
	static ScheduledExecutorService timer = 
			Executors.newSingleThreadScheduledExecutor();
	private static Set<Session> allSessions;
	DateTimeFormatter timeFormatter = 
			DateTimeFormatter.ofPattern("HH:mm:ss");
	@OnOpen
	public void showTime(Session session) {
		allSessions = session.getOpenSessions();
		// start the scheduler on the very first connection
		// to call sendTimeToAll every second
		timer.scheduleAtFixedRate(
				() -> sendTimeToAll(session),1,1,TimeUnit.SECONDS);
	}
	
	private void sendTimeToAll(Session session) {
		allSessions = session.getOpenSessions();
		for (Session sess: allSessions) {
			try {
				sess.getBasicRemote().sendText("Local time: " + 
			LocalTime.now().format(timeFormatter));
			}
			catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
}
