package com.revature.project0.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseUserDAO;

/**
 * Servlet implementation class ShowAllUsers
 */
public class ShowAllUsers extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseUserDAO showAllUsers = new DatabaseUserDAO();
		String jsonString = objectMapper.writeValueAsString(showAllUsers.showAllUsers());
		
		
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
	}

}
