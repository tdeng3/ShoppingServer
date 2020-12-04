package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.model.OrderStatus;
import com.revature.project0.model.Product;
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
	public boolean deleteMember (int id) {
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
		return false;
	}
	public ArrayList<Userlist> showAllUsers () {
		ArrayList<Userlist> userlist = new ArrayList<>();

		try(Connection connection = JDBCUtility.getConnection()){
			String sqlQuery = "SELECT * FROM userlist";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				int id = rs.getInt(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				String role = rs.getString(4);
				Userlist allUsers = new Userlist(id,email,password,role);
				userlist.add(allUsers);
			}
			return userlist;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
