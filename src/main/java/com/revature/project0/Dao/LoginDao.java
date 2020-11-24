package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.model.Userlist;
import com.revature.project0.util.JDBCUtility;

public class LoginDao {
	public ArrayList<String> getYourRole(String username, String password) {
		String sqlQuery = "SELECT role "
						+ "FROM userlist "
						+ "WHERE email='" + username + "'" +" and " +"password='" + password + "'";
		
		ArrayList<String> myRole = new ArrayList<>();
		myRole.add("Username or Password is wrong! Please try again.");
		try (Connection connection = JDBCUtility.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				String myrole = rs.getString(1);
				myRole.removeAll(myRole);
				myRole.add(myrole);
			}
			return myRole;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
		
		return myRole;
		
	}
	public Userlist addNewMember(Userlist userlist){
		try(Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false);
			String sqlQuery = "INSERT INTO userlist "
							+ "(email,password,role) "
							+ "VALUES "
							+ "(?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, userlist.getEmail());
			pstmt.setString(2, userlist.getPassword());
			pstmt.setString(3, userlist.getRole());
			if (pstmt.executeUpdate() != 1 ) {
				throw new SQLException("Inserting newUser failed, no rows were affected");
			}
			int autoId = 0;
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Inserting newUser failed, no ID generated");
			}
			
			connection.commit();
			return new Userlist(autoId, userlist.getEmail(), userlist.getPassword(), userlist.getRole());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
		
	}
}
