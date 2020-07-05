package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String aEmail = request.getParameter("txtAdminEmail");
		String aPassword = request.getParameter("txtAdminPassword");
		
		AdminBean ab = new AdminDao().loginAdmin(aEmail, aPassword);
		HttpSession session = request.getSession();
		
		if(ab!=null)
		{
			session.setAttribute("adminBean",ab);
			System.out.println(ab.getaName());
		}
		else
		{
			request.setAttribute("Error", "Please check username or password");
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}
	}

}
