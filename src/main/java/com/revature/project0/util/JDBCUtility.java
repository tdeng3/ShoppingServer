package com.revature.project0.util;

import java.sql.Connection;


import org.postgresql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
	public static Connection getConnection() throws SQLException {
		/*
		 * initialize the connection
		 */
		Connection connection = null;
		DriverManager.registerDriver(new Driver());
		/*
		 * set up environment variable
		 * String url = "jdbc:postgresql://localhost:5432/postgres";
		 * String username = "postgres";
		 * String password = "1462";
		 * 
		 * export PO_USER="postgres"
		 * launchctl setenv P0_USER $P0_USER
		 */
//		String username = System.getenv("P0_USER");
//		String password = System.getenv("P0_PW");
//		String url = System.getenv("DB_URL");
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "1462";
		
		connection = DriverManager.getConnection(url, username, password);
		
		
		return connection;
	}
}
