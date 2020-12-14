package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseProductDao;

/**
 * Servlet implementation class productWithStatusByUserId
 */
public class productWithStatusByUserId extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = Logger.getLogger(HttpServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Get request made to " + request.getRequestURI());
		DatabaseProductDao databaseProduct = new DatabaseProductDao();
		String user_id = request.getParameter("id");
		int userId = Integer.parseInt(user_id);
		
		
		String jsonString = objectMapper.writeValueAsString(databaseProduct.productWithStatusByUserId(userId));
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
	}

	

}
