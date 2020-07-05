package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;
import com.util.ValidationUtil;

public class BookInsertController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bName = request.getParameter("txtBookName");
		int bQty = Integer.parseInt(request.getParameter("txtBookQuantity"));
		int bPrice = Integer.parseInt(request.getParameter("txtBookPrice"));
		int aId = Integer.parseInt(request.getParameter("aid"));
		
		
		boolean isError=false;
		BookBean bb = new BookBean();
		
		if(ValidationUtil.isEmpty(bName))
		{
			isError=true;
			request.setAttribute("bname","Book Name is Required");
		}
		else
		{
			bb.setbName(bName);
		}
		
		if(isError==false)
		{
			bb.setbPrice(bPrice);
			bb.setbQty(bQty);
			bb.setaId(aId);

			if (new BookDao().addBook(bb))
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Error.jsp");
				System.out.println("Error in Inserting Book");
			}
		}
		else
		{
			request.getRequestDispatcher("insertBook.jsp").forward(request, response);
		}
	}

}
