package com.reveture.project0.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project0.Dao.DatabaseOrderStatusDao;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.login.Login;
import com.revature.project0.model.OrderStatus;
	
/**
 * Servlet implementation class StoreServe
 */
public class StoreServe extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
    public StoreServe() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Test connection");
//		Login checkRule = new Login();
//		String Rule = checkRule.myrole;
//		if(Rule.equals("Manager")){
//
//		}
		String p_rule = "Guest";
		p_rule = request.getParameter("Role");
		if(p_rule.equals("Manager")) {
		
			DatabaseProductDao databaseProduct = new DatabaseProductDao();
			String jsonString = objectMapper.writeValueAsString(databaseProduct.getAllProduct());
			response.getWriter().append(jsonString);
			response.setContentType("application/json");
			response.setStatus(200);
		
		} else {
			response.getWriter().append("You do not have permission");
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		BufferedReader reader = request.getReader();
		StringBuilder sb =new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		System.out.println(jsonString);
		try {
			OrderStatus order = objectMapper.readValue(jsonString, OrderStatus.class);
			DatabaseOrderStatusDao orderDao = new DatabaseOrderStatusDao();
			OrderStatus o =orderDao.insertStatus(order);
			System.out.println(o);
			response.setStatus(201);
		} catch (JsonProcessingException e) {
			response.setStatus(400);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
