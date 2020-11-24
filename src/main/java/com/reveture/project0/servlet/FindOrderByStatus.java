package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseProductDao;

/**
 * Servlet implementation class FindOrderByStatus
 */
public class FindOrderByStatus extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
    public FindOrderByStatus() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		DatabaseProductDao databaseProduct = new DatabaseProductDao();
		String p_name = request.getParameter("status");
		String jsonString = objectMapper.writeValueAsString(databaseProduct.findOrderByStatus(p_name));
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
