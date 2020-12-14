package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseProductDao;

/**
 * Servlet implementation class ShowProductList
 */
public class ShowProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseProductDao databaseProduct = new DatabaseProductDao();
		String jsonString = objectMapper.writeValueAsString(databaseProduct.showProductList());
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
		
	}

	

}
