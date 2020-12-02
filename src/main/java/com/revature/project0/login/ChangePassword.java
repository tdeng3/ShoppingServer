package com.revature.project0.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.project0.Dao.ChangePasswordDao;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email = request.getParameter("email");
			String newPassword = request.getParameter("password");
			ChangePasswordDao changeNewPassword = new ChangePasswordDao();
			Boolean changePassword = changeNewPassword.changePassword(email, newPassword);
			if(changePassword) {
				response.getWriter().append("User email: " +  email + " change password successfully." );
				response.setStatus(201);
			}else {
				response.getWriter().append("Please try again.");
				response.setStatus(500);
			
			}
			
		} catch (JsonProcessingException e) {
			response.setStatus(400);
		}
	}

}
