<%@page import="com.bean.UserBean"%>
<%@page import="com.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>


<%
	/* UserBean ub = (UserBean)session.getAttribute("userBean");
		if(ub!=null){ */
			
		AdminBean ab = (AdminBean)session.getAttribute("adminBean");
		if(ab!=null){
	
	List<BookBean> ListofBooks = (ArrayList)request.getAttribute("booklist"); 
%>

	<h3>Logged in User is: <%=ub.getuName() %></h3>
	<h1><a href="LogoutAdminController">Logout</a></h1>
	<table border="2" bgcolor="yellow" align="center">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Price</th>
			<th>Book Quantity</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	
		<% for(int i=0;i<ListofBooks.size();i++)
			{	BookBean bb = ListofBooks.get(i);
				%>
			<tr>
				<td><%=bb.getbId() %></td>
				<td><%=bb.getbName() %></td>
				<td><%=bb.getbPrice() %></td>
				<td><%=bb.getbQty() %></td>
				<td><a href= "BookDeleteController?bid=<%= bb.getbId()%>">Delete</a></td>
				<td><a href= "BookEditController?bid=<%= bb.getbId()%>">Update</a></td>
			</tr>
			
		<%}
		} else { 
			
			response.sendRedirect("UserLogin.jsp");
		}%>
	
	</table>
</body>
</html>