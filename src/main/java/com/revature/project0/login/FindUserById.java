package com.revature.project0.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.Dao.DatabaseUserDAO;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FindUserById
 */
public class FindUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = Logger.getLogger(HttpServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Get request made to " + request.getRequestURI());
		DatabaseUserDAO databaseProduct = new DatabaseUserDAO();
		String p_id = request.getParameter("id");
		int pID = Integer.parseInt(p_id);
		String jsonString = objectMapper.writeValueAsString(databaseProduct.findUserById(pID));
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);

	}
}
