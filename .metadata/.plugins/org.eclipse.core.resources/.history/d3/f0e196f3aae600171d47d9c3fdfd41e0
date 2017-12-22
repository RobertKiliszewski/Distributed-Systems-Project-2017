package ie.gmit.sw.RMI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
	private static final long serialVersionUID = 1L;
	
	//String csvFile = "dictionary.csv";
    String line = "";
    String cvsSplitBy = ",";
    HashMap<String,String> map = new HashMap<String, String>();
    
    public void read() {
    
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("file.csv"));
            while ((line = reader.readLine()) != null) {

                // use comma as separator
                String[] args = line.split(cvsSplitBy);
                
                map.put(args[0].toUpperCase(), line.toString());
            }
        	reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	protected DictionaryServiceImpl() throws RemoteException {
		super();
		read();
	}

	@Override
	public String lookup(String s) throws RemoteException {
		
		if(map.containsKey("\"" + s.toUpperCase() + "\"")) {
			//return s + " - " + map.get("\"" + s + "\"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String res = map.get("\"" + s.toUpperCase() + "\"");
			res = res.replace("\"", " ");
			return res;
		}
		else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Sorry, "+s+" was not found in dictionary";
		}
	}

	@Override
	public String add(String key, String desc) throws RemoteException {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(map.containsKey("\"" + key.toUpperCase() + "\"")) {
			return "Definition for " + key + " already exists in the dictionary..";
		}
		else {
			map.put("\"" + key.toUpperCase() + "\"", upper(key) + ", " + desc);
			try {
				addToCSV(key, desc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Successfully added " + key + " to the dictionary. Thank you.";
		}

	}
	
	public String upper(String s) {
		s.toLowerCase();
		char[] temp = s.toCharArray();
		temp[0] = Character.toUpperCase(temp[0]);
		String out = new String(temp);
		return out;
	}
	
	public void addToCSV(String key, String desc) throws IOException {
		FileWriter pw = new FileWriter("file.csv",true); 
		
		pw.append("\"" + upper(key) + "\"");
        pw.append(",");
        pw.append(" ");
        pw.append(",");
        pw.append(desc);
        pw.append("\n");
		
        pw.flush();
        pw.close();
	}
	
	public void mapToCSV(HashMap<String, String> m) {
		try (Writer writer = new FileWriter("file.csv")) {
			  for (HashMap.Entry<String, String> entry : map.entrySet()) {
			    writer.append(entry.getValue())
			          .append("\n");
			  }
			} catch (IOException ex) {
			  ex.printStackTrace(System.err);
			}
	}

	@Override
	public String delete(String key) throws RemoteException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(map.containsKey("\"" + key + "\"") || map.containsKey("\"" + key.toUpperCase() + "\"") || map.containsKey("\"" + upper(key) + "\"")) {
			if(map.containsKey("\"" + key + "\"")) {
				map.remove("\"" + key + "\"");
			}
			else if(map.containsKey("\"" + key.toUpperCase() + "\"")) {
				map.remove("\"" + key.toUpperCase() + "\"");
			}
			else if(map.containsKey("\"" + upper(key) + "\"")) {
				map.remove("\"" + upper(key) + "\"");
			}
			
			mapToCSV(map);
			return key + " has been successfully deleted from dictionary..";
		}
		else {
			return key + " doesn't exist in the dictionary..";
		}
	}
	
}
