package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Product;
import com.revature.project0.model.ProductList;
import com.revature.project0.util.JDBCUtility;

public class DatabaseProductDao {
	
	
	
	public ArrayList<ProductList> showProductList() {
		String sqlQuery = "SELECT * FROM productlist";
		ArrayList<ProductList> product = new ArrayList<>();
		try(Connection connection = JDBCUtility.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				String productDescription = rs.getString(3);
				String productPrice = rs.getString(4);
				ProductList product2 = new ProductList(id, productName, productDescription, productPrice);
				product.add(product2);
			}
			return product;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
		
	}
	public ArrayList<Product>productWithStatusByUserId(int userid) {
		String sqlQuery = "SELECT * FROM product p INNER JOIN orderStatus r ON p.orderID = r.id WHERE userid = " + userid + " ";
		ArrayList<Product> product = new ArrayList<>();
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				
				String name = rs.getString(3);
				String orderDate = rs.getString(4);
				int price = rs.getInt(5);
				int orderID = rs.getInt(7);
				String status = rs.getString(8);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				
				Product product2 = new Product(id, userid, name, orderDate, price, currStatus);
				product.add(product2);
			}
			return product;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return product;
		
	}
	
	public ArrayList<Product> getAllProduct() {
	
		String sqlQuery = "SELECT * FROM product p INNER JOIN orderStatus r On p.orderID = r.id";
		
		ArrayList<Product> product = new ArrayList<>();
		try (Connection connection = JDBCUtility.getConnection()) {
			/*
			 * Simple statement is good enough
			 * import from sql.Statement
			 */
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				int userId = rs.getInt(2);
				String name = rs.getString(3);
				String orderDate = rs.getString(4);
				int price = rs.getInt(5);
				int orderID = rs.getInt(7);
				String status = rs.getString(8);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				
				Product product2 = new Product(id, userId, name, orderDate, price, currStatus);
				product.add(product2);
			}
			return product;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return product;
		
	}
	
	public Product insertProduct (int userId, String productName, String orderDate, int price, OrderStatus status) {
		try(Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false);
			String sqlQuery = "INSERT INTO product"
							+ "(userId, name,orderDate,price, orderID)"
							+ "VALUES "
							+ "(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, userId);
			pstmt.setString(2, productName);
			pstmt.setString(3, orderDate);
			pstmt.setInt(4, price);
			pstmt.setInt(5, status.getId());
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
			return new Product(autoId, userId,productName,orderDate,price,status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteProduct(int id) {
		try (Connection connection = JDBCUtility.getConnection()) {
			
			String sqlQuery = "DELETE FROM product WHERE id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() != 0 ) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
				int userId = rs.getInt(2);
				String name = rs.getString(3);
				String orderDate = rs.getString(4);
				int price = rs.getInt(5);
				int orderID = rs.getInt(7);
				String status = rs.getString(8);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				
				Product product2 = new Product(id, userId, name, orderDate, price, currStatus);
				products.add(product2);
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
				int userId = rs.getInt(2);
				String name = rs.getString(3);
				String orderDate = rs.getString(4);
				int price = rs.getInt(5);
				int orderID = rs.getInt(7);
				String status = rs.getString(8);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				
				Product product2 = new Product(id, userId, name, orderDate, price, currStatus);
				products.add(product2);
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
				int userId = rs.getInt(2);
				String name = rs.getString(3);
				String orderDate = rs.getString(4);
				int price = rs.getInt(5);
				int orderID = rs.getInt(7);
				String status = rs.getString(8);
				
				OrderStatus currStatus = new OrderStatus(orderID, status);
				
				Product product2 = new Product(id, userId, name, orderDate, price, currStatus);
				products.add(product2);
			}
			return products;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return products;
	}
}
