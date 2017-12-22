package ie.gmit.sw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.sw.model.DictionaryModel;

public class DictionaryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String word;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
		
		word = request.getParameter("word");

		if ((word != null && !word.isEmpty())) {

			DictionaryModel service = new DictionaryModel();
			
			String description = service.lookup(word);
			
			messages.put("description", description);
			
			if(description != null && !description.isEmpty()) {
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				dispatcher.forward(request, response);
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			
			messages.put("description", "Oops.. Something went wrong..");
			RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
