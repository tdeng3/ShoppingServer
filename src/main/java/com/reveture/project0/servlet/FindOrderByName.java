package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
