package ie.gmit.sw.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ie.gmit.sw.rmi.DictionaryService;

public class Service {

	private final String SERVICE_URL = "rmi://localhost:1099/lookup";
	
	public String lookup(String s) {
			
		try {
			
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			return lookup.lookup(s);
	
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		return " ";
		
	}
}
