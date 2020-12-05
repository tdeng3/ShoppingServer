package com.revature.project0.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseUserDAO;



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
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			boolean isUserExist = false;
			if (email == null || password == null) {
				response.getWriter().append("Username or password is empty.");
			}
			DatabaseUserDAO databaseUserDao = new DatabaseUserDAO();
			isUserExist = databaseUserDao.checkUserExist(email, password);
			
			if (isUserExist) {
				String myRole = databaseUserDao.getYourRole(email,password);
				response.getWriter().append("You have logged in as " + myRole);
				response.setContentType("application/json");
				response.setStatus(200);
			} else {
				response.getWriter().append("User doesn't exist.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
