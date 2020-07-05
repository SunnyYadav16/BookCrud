package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String username = "root";	
	static String password = "root";
	static String connectionUrl = "jdbc:mysql://localhost:3306/Sunny";
	
	public static Connection getDBConnection()
	{
		Connection conn =null;
		
		try 
		{
			Class.forName(driverClassName);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}		
		
		try
		{
			conn = DriverManager.getConnection(connectionUrl, username, password);
			
			if(conn!=null)
				System.out.println("Connected Successfully to Database");
			else
				System.out.println("Not Connected");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
	public static void main(String[] args) 
	{
		DBConnection.getDBConnection();

	}
}
