package com.revature.project0.login;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.AddOrDeleteMemberDAO;
import com.revature.project0.model.Userlist;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = reader.readLine()) != null ) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		try {
			Userlist newUser = objectMapper.readValue(jsonString, Userlist.class);
			AddOrDeleteMemberDAO registerDao = new AddOrDeleteMemberDAO();
			Userlist user = registerDao.insertNew(newUser);
			
			String userJSON = objectMapper.writeValueAsString(user);
			response.getWriter().append(userJSON);
			response.setContentType("application/json");
			response.setStatus(201);
		} catch (JsonProcessingException e) {
			response.setStatus(400);
		}
	}

}
