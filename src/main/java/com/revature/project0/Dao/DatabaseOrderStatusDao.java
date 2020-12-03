package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.project0.model.OrderStatus;
import com.revature.project0.util.JDBCUtility;

public class DatabaseOrderStatusDao {
//	public OrderStatus insertStatus (OrderStatus order) {
//		
//		try(Connection connection = JDBCUtility.getConnection()) {
//			connection.setAutoCommit(false);
//			String sqlQuery = "INSERT INTO orderStatus "
//							+ "(status)"
//							+ "VALUES"
//							+ "(?)";
//			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
//			pstmt.setString(1, order.getStatus());
//			if (pstmt.executeUpdate() != 1) {
//				throw new SQLException("Inserting failed.");
//			}
//			int autoId = 0;
//			ResultSet generatedKeys = pstmt.getGeneratedKeys();
//			if (generatedKeys.next()) {
//				autoId = generatedKeys.getInt(1);
//			} else {
//				throw new SQLException("failed");
//			}
//			connection.commit();
//			
//			return new OrderStatus(autoId, order.getStatus());
//			
//			
//			
//			
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace(); 
//		}
//		return null;
//		
//	}
	public OrderStatus findStatusByName(String name) {
		try (Connection connection = JDBCUtility.getConnection()){
			String sqlQuery = "SELECT * FROM orderstatus o WHERE o.status = ? ";
							
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String status = rs.getString(2);
				System.out.println("I am here 2");
				return new OrderStatus(id, status);
			}else {
				System.out.println("I am here.");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
