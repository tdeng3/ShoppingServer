package com.revature.project0.login;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.InsertDAO;
import com.revature.project0.model.Userlist;
import com.revature.project0.model.members;

/**
 * Servlet implementation class RegisterAndInsertNew
 */
public class RegisterAndInsertNew extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		BufferedReader reader = request.getReader();
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = reader.readLine()) != null ) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		try {
			members newUser = objectMapper.readValue(jsonString, members.class);
			InsertDAO insertDao = new InsertDAO();
			members user = insertDao.insertNew(newUser);
			
			String userJSON = objectMapper.writeValueAsString(user);
			response.getWriter().append(userJSON);
			response.setContentType("application/json");
			response.setStatus(201);
		} catch (JsonProcessingException e) {
			response.setStatus(400);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
