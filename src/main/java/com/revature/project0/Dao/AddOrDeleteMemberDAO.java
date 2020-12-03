package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.project0.model.Userlist;
import com.revature.project0.util.JDBCUtility;

public class AddOrDeleteMemberDAO {
	public Userlist insertNew (Userlist newUser) {
		try (Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false);
			String sqlQuery = "INSERT INTO userlist "
							+ "(email, password,role)"
							+ "VALUES"
							+ "(?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, newUser.getEmail());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getRole());
			if (pstmt.executeUpdate() != 1 ) {
				throw new SQLException("Failed");
			}
			int autoId = 0;
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Failed again");
			}
			connection.commit();
			return new Userlist(autoId, newUser.getEmail(), newUser.getPassword(),newUser.getRole());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Boolean deleteMember (int id) {
		try (Connection connection = JDBCUtility.getConnection()) {
			
			String sqlQuery = "DELETE FROM userlist WHERE id = ?";
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
		return null;
	}
}