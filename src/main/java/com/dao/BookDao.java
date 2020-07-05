package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookBean;
import com.util.DBConnection;
import com.util.DBConnection2;

public class BookDao 
{
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	
	public boolean addBook(BookBean bb)
	{
		boolean flag = false;
		
		conn = DBConnection2.getDBConnection();
		if(conn!=null)
		{
			String insertSql = "insert into Book(bname,bprice,bquantity,aid)values(?,?,?,?)";
			
			try 
			{
				pstmt = conn.prepareStatement(insertSql);
				
				pstmt.setString(1, bb.getbName());
				pstmt.setInt(2,bb.getbPrice());
				pstmt.setInt(3,bb.getbQty());
				pstmt.setInt(4,bb.getaId());
				
				int res = pstmt.executeUpdate();
				
				if(res>0)
				{
					flag=true;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		return flag;
	}
	
	
	public  List<BookBean> booklist()
	{
		List<BookBean> ListOfBooks = new ArrayList<BookBean>();
		
		conn = DBConnection2.getDBConnection();
		if(conn!=null)
		{
			String selectSQL = "Select *  from book";
			
			try 
			{
				pstmt = conn.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				
				while (rs.next())
				{
					BookBean bb = new BookBean();
					bb.setbId(rs.getInt("bid"));
					bb.setbName(rs.getString("bname"));
					bb.setbPrice(rs.getInt("bPrice"));
					bb.setbQty(rs.getInt("bQuantity"));
					ListOfBooks.add(bb);
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return ListOfBooks;	
	}
	
	public boolean DeleteBook(int bid)
	{
		boolean flag = false;
		conn = DBConnection2.getDBConnection();
		if(conn!=null)
		{
			String deleteSql = "Delete from book where bId=?";
			
			try 
			{
				pstmt = conn.prepareStatement(deleteSql);
				
				pstmt.setInt(1,bid);
				int res = pstmt.executeUpdate();
				
				if(res>0)
				{
					flag=true;
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	public BookBean getDataById(int bId)
	{
		conn = DBConnection2.getDBConnection();
		BookBean bb = new BookBean();
		if(conn!=null)
		{
			String selectSql = "Select * from book where bid=?";
			
			try 
			{
				pstmt = conn.prepareStatement(selectSql);
				pstmt.setInt(1,bId);
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					bb.setbId(rs.getInt("bid"));
					bb.setbName(rs.getString("bname"));
					bb.setbPrice(rs.getInt("bPrice"));
					bb.setbQty(rs.getInt("bQuantity"));
				}
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return bb;
	}


	public boolean updateBooK(BookBean bb) {
		
		conn = DBConnection2.getDBConnection();
		boolean flag = false;
		if(conn!=null)
		{
			String updateSQL = "Update book set bname=?, bprice=?, bquantity=? where bid=?";
			
			try 
			{
				pstmt = conn.prepareStatement(updateSQL);
			
				pstmt.setString(1,bb.getbName());
				pstmt.setInt(2, bb.getbPrice());
				pstmt.setInt(3, bb.getbQty());
				pstmt.setInt(4,bb.getbId());
				
				int res = pstmt.executeUpdate();
				
				if(res>0)
				{
					flag = true;
				}
			
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}
		return flag;
	}
}
