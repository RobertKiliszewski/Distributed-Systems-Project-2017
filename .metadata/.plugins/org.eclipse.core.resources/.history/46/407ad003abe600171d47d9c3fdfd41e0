package ie.gmit.sw.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		final int PORT = 1099;
		
		DictionaryService lookup = new DictionaryServiceImpl();
		
		LocateRegistry.createRegistry(PORT);
		
		Naming.rebind("lookup", lookup);

		System.out.println("Dictionary service is ready.");
	}

}