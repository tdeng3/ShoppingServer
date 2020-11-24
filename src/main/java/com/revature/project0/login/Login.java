package com.revature.project0.login;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.LoginDao;
import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Userlist;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
	public String myrole;
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LoginDao loginDao = new LoginDao();
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String jsonString = objectMapper.writeValueAsString(loginDao.getYourRole(user,password));
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
		myrole = jsonString;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		try {
			Userlist userlist = objectMapper.readValue(jsonString, Userlist.class);
			LoginDao loginDao = new LoginDao();
			
			
			
			Userlist u = loginDao.addNewMember(userlist);
			String userJSON = objectMapper.writeValueAsString(u);
			System.out.println("hi" + u);
			response.getWriter().append(userJSON);
			response.setContentType("application/json");
			response.setStatus(201);
			
			
		} catch (JsonProcessingException e) {
			response.setStatus(400);
		}	
	}

}
