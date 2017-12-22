package ie.gmit.sw.controller;

//Imports
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.sw.service.Service;

public class Controller extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private String dictionaryWord;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*This sets up a map variable in order to store the words in the 
		 * Dictionary file in the variable*/
		
		//Declare Map 
		Map<String, String> displayMessage = new HashMap<String, String>();
        request.setAttribute("messages", displayMessage);
		
        //Request every word from the dictionary 
		dictionaryWord = request.getParameter("word");

		//If the dictionary is empty 
		if ((dictionaryWord != null && !dictionaryWord.isEmpty())) {

			Service service = new Service();
			String modelResult = service.lookup(dictionaryWord);
			
			displayMessage.put("description", modelResult);
			
			if(modelResult != null && !modelResult.isEmpty()) {
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				dispatcher.forward(request, response);
				
			} 
			
			else {
				
				//Request the dispatcher to access lookup.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				dispatcher.forward(request, response);
				
			}
		} 
		
		else {
			
			displayMessage.put("description", "Error");
			RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
			dispatcher.forward(request, response);
			
		}	
	}
}
