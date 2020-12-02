package com.revature.project0.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.project0.Dao.AddOrDeleteMemberDAO;
import com.revature.project0.Dao.ChangePasswordDao;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String idInString = request.getParameter("id");
			int id = Integer.parseInt(idInString);
			AddOrDeleteMemberDAO deleteMembers = new AddOrDeleteMemberDAO();
			Boolean deleteMem = deleteMembers.deleteMember(id);
			if(deleteMem) {
				response.getWriter().append("User id: " +  id + " has been deleted successfully." );
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
