package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Product;
import com.revature.project0.util.JDBCUtility;

public class DatabaseProductDao {
	public ArrayList<Product> getAllProduct() {
		/*
		 * Since we have two tables, we need to write a sqlQuery to return product with order status.
		 */
		
		String sqlQuery = "SELECT * FROM product p INNER JOIN orderStatus r On p.orderID = r.id";
		ArrayList<Product> products = new ArrayList<>();
		
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int orderID = rs.getInt(4);
				String status = rs.getString(5);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				Product product = new Product(id, name, currStatus);
				products.add(product);
			}
			return products;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return products;
		
	}
	
	public Product insertProduct (String productName, OrderStatus status) {
		try(Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false);
			String sqlQuery = "INSERT INTO product"
							+ "(name,orderID)"
							+ "VALUES "
							+ "(?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, productName);
			pstmt.setInt(2, status.getId());
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Inserting product failed, no rows were affected");
				
			}
			int autoId = 0;
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Inserting product failed, no ID generated");
			}
			connection.commit();
			return new Product(autoId, productName,status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> findOrderById(int p_id) {
		/*
		 * Since we have two tables, we need to write a sqlQuery to return product with order status.
		 */
		String sqlQuery = "SELECT *"
						+ "FROM product p "
						+ "INNER JOIN orderStatus o "
						+ "On p.orderID = o.id "
						+ "Where o.id = " + p_id + " ";
		ArrayList<Product> products = new ArrayList<>();
		
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int orderID = rs.getInt(4);
				String status = rs.getString(5);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				Product product = new Product(id, name, currStatus);
				products.add(product);
			}
			return products;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return products;
		
	}
	public ArrayList<Product> findOrderByName(String p_name) {
		String sqlQuery = "SELECT *"
				+ "FROM product p "
				+ "INNER JOIN orderStatus o "
				+ "On p.orderID = o.id "
				+ "Where p.name = '" + p_name + "'";
		ArrayList<Product> products = new ArrayList<>();
		
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int orderID = rs.getInt(4);
				String status = rs.getString(5);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				Product product = new Product(id, name, currStatus);
				products.add(product);
			}
			return products;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return products;
	}
	public ArrayList<Product> findOrderByStatus(String o_status) {
		String sqlQuery = "SELECT *"
				+ "FROM product p "
				+ "INNER JOIN orderStatus o "
				+ "On p.orderID = o.id "
				+ "Where o.status = '" + o_status + "'";
		ArrayList<Product> products = new ArrayList<>();
		
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int orderID = rs.getInt(4);
				String status = rs.getString(5);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				Product product = new Product(id, name, currStatus);
				
				products.add(product);
			}
			return products;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return products;
	}
}
