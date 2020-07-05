package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection2 
{
//	static String username = "postgres";	
//	static String password = "root";
//	static String connectionUrl = "jdbc:postgresql://localhost:5432/sunny";
	
	static String username = "dpcnwfnpgdijqu";  
	static String password = "91c3d00a042da4e3ac40855f0cedcfd2f1d028ef97a1cec1b501945acf85a776";
	static String driverClassName = "org.postgresql.Driver";
	static String connectionUrl = "jdbc:postgresql://ec2-54-211-210-149.compute-1.amazonaws.com:5432/dvmk8umfs9lc5?sslmode=require";
	
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
		DBConnection2.getDBConnection();

	}
}
