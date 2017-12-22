package ie.gmit.sw.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		DictionaryService wordSearch = new DictionaryServiceImpl();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("lookup", wordSearch);
		System.out.println("Dictionary Ready, Start lookup.jsp to begin!");
		
	}
}