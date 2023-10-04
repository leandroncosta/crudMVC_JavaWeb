package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.utils.Colors;

public class Database {

	private static final String URL = "jdbc:mysql://localhost:3306/java_crud";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}

		try {
			
			Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
			 System.out.println(Colors.GREEN + "Connected to database" + Colors.RESET);
			return connection;

		} catch (SQLException e) {
          System.out.println("Not connected to database. Message: " + e.getMessage());
          return null;
		}
	}
}
