package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.Dao.DatabaseUserDAO;
import com.sun.org.apache.xerces.internal.parsers.DTDConfiguration;

/**
 * Servlet implementation class DeleteProduct
 */
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String idInString = request.getParameter("id");
			int id = Integer.parseInt(idInString);
			DatabaseProductDao deleteProducts = new DatabaseProductDao();
			Boolean deleteProd = deleteProducts.deleteProduct(id);
			if(deleteProd) {
				response.getWriter().append("Product id: " +  id + " has been deleted successfully." );
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
