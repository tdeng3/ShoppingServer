package com.reveture.project0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaticResourceServlet
 */
public class StaticResourceServlet extends HttpServlet {
	
    public StaticResourceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		String resource = request.getRequestURI().replace("/Project0", "");
		if(resource != null ) {
			switch (resource) {
				case "/":
					System.out.println("invoked forwarding of index.html");
					request.getRequestDispatcher("static/index.html").include(request, response);
					response.setContentType("text/html");
					response.setStatus(200);
					break;
				case "/userlist":
					request.getRequestDispatcher("/static/userlist.html").include(request, response);
					response.setContentType("text/html");
					response.setStatus(200);
					break;
				case "/product-list":
					request.getRequestDispatcher("/static/product-list.html").include(request, response);
					response.setContentType("text/html");
					response.setStatus(200);
					break;
				case "/shopping-cart":
					request.getRequestDispatcher("/static/shopping-cart.html").include(request, response);
					response.setContentType("text/html");
					response.setStatus(200);
					break;
				
				
				case "/styles/stylesheet":
					System.out.println("invoked forwarding of styles.css");
					request.getRequestDispatcher("/static/css/styles.css").include(request, response);
					response.setContentType("text/css");
					response.setStatus(200);
					break;
				case "/js/userlist":
					System.out.println("invoked forwarding of userlist.js");
					request.getRequestDispatcher("/static/js/userlist.js").include(request, response);
					response.setContentType("text/javascript");
					response.setStatus(200);
					break;
				case "/js/productlist":
					System.out.println("invoked forwarding of productlist.js");
					request.getRequestDispatcher("/static/js/productlist.js").include(request, response);
					response.setContentType("text/javascript");
					response.setStatus(200);
					break;
				case "/js/shoppingcart":
					System.out.println("invoked forwarding of shoppingcart.js");
					request.getRequestDispatcher("/static/js/shoppingcart.js").include(request, response);
					response.setContentType("text/javascript");
					response.setStatus(200);
					break;
				case "/img/ShoppingTrends.jpeg":
					System.out.println("invoked forwarding of ShoppingTrends.jpeg");
					request.getRequestDispatcher("/static/img/ShoppingTrends.jpeg").include(request, response);
					response.setContentType("image/jpeg");
					response.setStatus(200);
					break;
				default:
					response.setStatus(404);
			}
			
			
				
		} else {
			response.setStatus(404);
		}
	}


}
