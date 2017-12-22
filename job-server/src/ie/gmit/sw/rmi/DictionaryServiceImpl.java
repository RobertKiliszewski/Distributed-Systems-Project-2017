package ie.gmit.sw.rmi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
	
	private static final long serialVersionUID = 1L;
	
	
    String newDictionaryLine;
    HashMap<String,String> dictionary_HashMap = new HashMap<String, String>();

	protected DictionaryServiceImpl() throws RemoteException {
		
		super();
		
	}

	@Override
	public String lookup(String s) throws RemoteException {
		
		/* Stores the dictionary file in the map in order to be 
		 * Able to search through it*/
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("dictionaryfile.csv"));
			
            while ((newDictionaryLine = reader.readLine()) != null) {

            	//Split the line when encountering a comma 
                String[] args = newDictionaryLine.split(",");
                dictionary_HashMap.put(args[0].toUpperCase(), newDictionaryLine.toString());
                
            }
            //Close the Reader after it reads the dictionary file
            
        	reader.close();
        	
		} catch (IOException e) {
	
			e.printStackTrace();
			
		}
		
		if(dictionary_HashMap.containsKey("\"" + s.toUpperCase() + "\"")) {
			
			try {
				
				//Wait 1ms to simulate server response
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			String response = dictionary_HashMap.get("\"" + s.toUpperCase() + "\"");
			response = response.replace("\"", " ");
			return response;
			
		}
		
		else {
			
			try {
				
				//Wait 1ms to simulate server response
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			//If the word you searched is not there then display this message to the user
			return "Response: Oops! "+s+" does not exist in our dictionary, try another word";
			
		}
	}
}
