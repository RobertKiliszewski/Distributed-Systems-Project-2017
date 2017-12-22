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

public class DictionaryControllerAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String key, desc;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
		
		key = request.getParameter("key");
		desc = request.getParameter("desc");

		if ((key != null && !key.isEmpty()) && (desc != null && !desc.isEmpty())) {

			DictionaryModel service = new DictionaryModel();
			
			String description = service.add(key, desc);
			
			messages.put("description", description);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);

		} else {
			
			messages.put("description", "Oops.. Something went wrong..");
			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
