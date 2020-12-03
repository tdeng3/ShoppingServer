package com.reveture.project0.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project.service.ProductService;
import com.revature.project0.Dao.DatabaseOrderStatusDao;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.exception.StatusNotFoundException;
import com.revature.project0.login.Login;
import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Product;
import com.revature.project0.template.InsertProductTemplate;
	
/**
 * Servlet implementation class StoreServe
 */
public class StoreServe extends HttpServlet {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
	
	public StoreServe() {
		super();
	}
	
	public StoreServe(ObjectMapper objectMapper, ProductService productService) {
		this.objectMapper = objectMapper;
		this.productService = productService;
	}
	
	
	
    
    private static Logger logger = Logger.getLogger(HttpServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.debug("Get request made to " + request.getRequestURI());

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
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null ) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		//System.out.println("jsonString" + jsonString);
		try {
			InsertProductTemplate productData = objectMapper.readValue(jsonString, InsertProductTemplate.class);
			
			//System.out.println("productData: " + productData);
			Product product =productService.insertProducts(productData) ;
			
			//System.out.println("product: " +product);
			
			
			
			
			String insertedProductJSON = objectMapper.writeValueAsString(product);
			response.getWriter().append(insertedProductJSON);
			
			response.setContentType("application/json");
			response.setStatus(201);
			
		} catch (JsonEOFException | StatusNotFoundException e) {
			
			response.setStatus(400);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
