package com.revature.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.project0.model.members;
import com.revature.project0.util.JDBCUtility;

public class InsertDAO {
	public members insertNew (members newUser) {
		try (Connection connection = JDBCUtility.getConnection()) {
			connection.setAutoCommit(false);
			String sqlQuery = "INSERT INTO members "
							+ "(names, roles)"
							+ "VALUES"
							+ "(?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, newUser.getNames());
			pstmt.setString(2, newUser.getRoles());
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
			return new members(autoId, newUser.getNames(), newUser.getRoles());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
