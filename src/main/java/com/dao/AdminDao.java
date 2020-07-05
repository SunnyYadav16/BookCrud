package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.util.DBConnection2;

public class AdminDao 
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AdminBean loginAdmin(String aEmail, String aPassword)
	{
		conn = DBConnection2.getDBConnection();
		AdminBean ab = new AdminBean();
		
		if(conn!=null)
		{
			String SelectSql = "Select * from Admin where aemail=? and apassword=?";
			try 
			{
				pstmt = conn.prepareStatement(SelectSql);
				pstmt.setString(1,aEmail);
				pstmt.setString(2,aPassword);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ab.setaId(rs.getInt("aid"));
					ab.setaName(rs.getString("aname"));
					ab.setaEmail(rs.getString("aemail"));
					ab.setaPassword(rs.getString("apassword"));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
					
		}
		return ab;
	}
}
