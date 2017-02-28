package com.practicaljava.lesson24;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Makes the remote object, StockServerImpl, available to clients. To clients
 * this server will be known as "QuoteService".
 * @author David Lall
 *
 */

public class StartServer {
	public static void main(String[] args) {
		try {
			// create the registry on port 1099
			LocateRegistry.createRegistry(1099);
			// instantiate the StockServerInmpl and bind it to the registry
			// under the name QuoteServce
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1099/QuoteService",ssi);
		}
		catch (MalformedURLException e1) {
			System.out.println(e1.getMessage());
		}
		catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
}