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
 * Servlet implementation class FindOrderByName
 */
public class FindOrderByName extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
    public FindOrderByName() {
        super();
    }
    private static Logger logger = Logger.getLogger(HttpServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		logger.debug("Get request made to " + request.getRequestURI());
		
		DatabaseProductDao databaseProduct = new DatabaseProductDao();
		String p_name = request.getParameter("name");
		String jsonString = objectMapper.writeValueAsString(databaseProduct.findOrderByName(p_name));
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
