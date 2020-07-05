package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.AuthorBean;
import com.util.DBConnection2;

public class AuthorDao 
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<AuthorBean> authorList()
	{
		List<AuthorBean> authorList = new ArrayList<AuthorBean>();
		AuthorBean ab;
		conn=DBConnection2.getDBConnection();
		if(conn!=null)
		{
			String selectSql = "select * from author";
			try 
			{
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{	ab = new AuthorBean();
					ab.setaId(rs.getInt("aid"));
					ab.setaName(rs.getString("aname"));
					authorList.add(ab);
				}
			
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return authorList;
	}
	
}
