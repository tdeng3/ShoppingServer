package com.revature.project.service;

import java.util.ArrayList;

import com.revature.project0.Dao.DatabaseOrderStatusDao;
import com.revature.project0.Dao.DatabaseProductDao;
import com.revature.project0.exception.StatusNotFoundException;
import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Product;
import com.revature.project0.template.InsertProductTemplate;

public class ProductService {
	private DatabaseProductDao productDao;
	private DatabaseOrderStatusDao statusDao;
	public ProductService() {
		this.productDao = new DatabaseProductDao();
		this.statusDao = new DatabaseOrderStatusDao();

	}
	public ProductService(DatabaseProductDao productDao, DatabaseOrderStatusDao statusDao) {
		this.productDao = productDao;
		this.statusDao = statusDao;
	}
	public Product getAllProduct(){
		return productDao.getAllProduct();
	}
	public Product insertProducts(InsertProductTemplate productTemplate) throws StatusNotFoundException{
		OrderStatus stats; 
		stats = statusDao.findStatusByName(productTemplate.getStatus());
		//System.out.println("stats : " + stats);
		if (stats == null) {
			throw new StatusNotFoundException("THE USER ATTPEMTED TO INSERT A PRODUCT FOR A STATUS WHICH DOESN'T EXIST");
		}
		//System.out.println("name is: " + productTemplate.getName() );
		return productDao.insertProduct(productTemplate.getName(), stats);
		
	}
}
