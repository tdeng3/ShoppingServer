package com.reveture.project0.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project.service.ProductService;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.exception.StatusNotFoundException;
import com.revature.project0.model.Product;
import com.revature.project0.template.InsertProductTemplate;

/**
 * Servlet implementation class ProductWithStatus
 */
public class ShowAllOrInsertProduct extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
	
	public ShowAllOrInsertProduct() {
		super();
	}
	
	public ShowAllOrInsertProduct(ObjectMapper objectMapper, ProductService productService) {
		this.objectMapper = objectMapper;
		this.productService = productService;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		DatabaseProductDao databaseProduct = new DatabaseProductDao();
		String jsonString = objectMapper.writeValueAsString(databaseProduct.getAllProduct());
		response.getWriter().append(jsonString);
		response.setContentType("application/json");
		response.setStatus(200);
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null ) {
			sb.append(line);
		}
		String jsonString = sb.toString();
		try {
			InsertProductTemplate productData = objectMapper.readValue(jsonString, InsertProductTemplate.class);
			Product product =productService.insertProducts(productData) ;
			String insertedProductJSON = objectMapper.writeValueAsString(product);
			response.getWriter().append(insertedProductJSON);
			
			response.setContentType("application/json");
			response.setStatus(201);
			
		} catch (JsonEOFException |StatusNotFoundException e) {
			response.getWriter().append(e.toString());
			
			System.out.println(e.toString());
			response.setStatus(400);
		}
		
	}

	

}
