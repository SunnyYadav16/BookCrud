package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.bean.UserBean;
import com.util.DBConnection;
import com.util.DBConnection2;

public class UserDao 
{
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	
	public boolean addUser(UserBean ub)
	{
		boolean flag = false;
		
		conn = DBConnection2.getDBConnection();
		if(conn!=null)
		{
			String insertSQL = "insert into CRUD_User(UserName,Email,Password,Age)values(?,?,?,?)";
			
			try 
			{
				pstmt = conn.prepareStatement(insertSQL);
			
				pstmt.setString(1, ub.getuName());
				pstmt.setString(2, ub.getuEmail());
				pstmt.setString(3, ub.getuPassword());
				pstmt.setInt(4,ub.getuAge());
				
				int res = pstmt.executeUpdate();
				
				if(res>0)
					flag=true;
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}	
		return flag;
	}
	
	
	public UserBean loginUser(String uEmail, String uPassword)
	{
		conn = DBConnection2.getDBConnection();
		UserBean ub = new UserBean();
		
		if(conn!=null)
		{
			String SelectSql = "Select * from crud_user where email=? and password=?";
			try 
			{
				pstmt = conn.prepareStatement(SelectSql);
				pstmt.setString(1,uEmail);
				pstmt.setString(2,uPassword);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ub.setuId(rs.getInt("uid"));
					ub.setuName(rs.getString("username"));
					ub.setuEmail(rs.getString("email"));
					ub.setuPassword(rs.getString("password"));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
					
		}
		return ub;
	}
}
