package com.dajiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	 private final static String driver = "com.mysql.jdbc.Driver";
     private final static String dbName = "test";
     private final static String password = "zhou1234";
     private final static String username = "dajiao";
     private final static String url = "jdbc:mysql://10.0.18.2:3306/" + dbName;
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("get connection success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
