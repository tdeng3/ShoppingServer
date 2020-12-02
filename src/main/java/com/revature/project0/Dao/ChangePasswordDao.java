package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.project0.util.JDBCUtility;

public class ChangePasswordDao {
	public Boolean changePassword(String email, String newPassword) {
		try (Connection connection = JDBCUtility.getConnection()) {
			String sqlQuery = "UPDATE userlist "
							+ "SET password = ?"
							+ "WHERE email = ?";
			//update users set pass=? where email=?
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setString(1, newPassword);
			pstmt.setString(2, email);
			
			if (pstmt.executeUpdate() != 0) {
				System.out.println("I am here! change password");
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
}
