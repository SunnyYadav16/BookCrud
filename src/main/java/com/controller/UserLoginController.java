package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.bean.UserBean;
import com.dao.AdminDao;
import com.dao.UserDao;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String aEmail = request.getParameter("txtUserEmail");
		String aPassword = request.getParameter("txtUserPassword");
		
		UserBean ub = new UserDao().loginUser(aEmail, aPassword);
		HttpSession session = request.getSession();
		
		if(ub!=null)
		{
			session.setAttribute("userBean",ub);
			request.getRequestDispatcher("BookListController").forward(request, response);
		}
		else
		{
			request.setAttribute("Error", "Please check username or password");
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}
	}
}
