package ie.gmit.sw.model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ie.gmit.sw.RMI.DictionaryService;

public class DictionaryModel {

	private final int PORT = 1099;
	private final String SERVICE_URL = "rmi://localhost:"+PORT+"/lookup";
	
	public String lookup(String s) {
			
		try {
			
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			return lookup.lookup(s);
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
	
	public String add(String key, String desc) {
		try {
			
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			return lookup.add(key, desc);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
	
	public String delete(String key) {
		try {
			
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			return lookup.delete(key);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
}
