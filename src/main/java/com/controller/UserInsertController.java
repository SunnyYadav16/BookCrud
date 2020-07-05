package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class UserInsertController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uName = request.getParameter("txtUserName");
		String uEmail = request.getParameter("txtUserEmail");
		String uPassword = request.getParameter("txtUserPassword");
		int uAge = Integer.parseInt(request.getParameter("txtUserAge"));
		
		UserBean ub = new UserBean();
		ub.setuName(uName);
		ub.setuEmail(uEmail);
		ub.setuPassword(uPassword);
		ub.setuAge(uAge);
		
		if(new UserDao().addUser(ub))
		{
			response.sendRedirect("UserSuccess.html");
		}
		else
		{
			response.sendRedirect("Error");
		}
	}

}
