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
		Connection connection = null;
		DriverManager.registerDriver(new Driver());

		String username = "postgres";
		String password = "7086559886";
		String url="jdbc:postgresql://shoppingserverdatabase.cu4yhoaec4da.us-east-2.rds.amazonaws.com:5432";
		
		
		//connection = DriverManager.getConnection(url, username, password);
		connection = DriverManager.getConnection("jdbc:postgresql://shoppingserverdatabase.cu4yhoaec4da.us-east-2.rds.amazonaws.com:5432/postgres?user=postgres&password=7086559886");
		
		
		return connection;
	}
}
