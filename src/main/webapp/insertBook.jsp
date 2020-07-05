<%@page import="com.bean.AuthorBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AuthorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Book</title>
</head>
<body>

<form action="BookInsertController">

	<table>
		<tr>
			<td>Book Name:-</td>
			<td><input type="text" name="txtBookName">
			<%-- ${bname} --%>
			</td>
		</tr>
			
		<tr>
			<td>Book Price:-</td>
			<td><input type="text" name="txtBookPrice"></td>
		</tr>
		
	
		<tr>
			<td>Book Quantity:-</td>
			<td><input type="text" name="txtBookQuantity"></td>
		</tr>
		
		<tr>
			<td>Author</td>
			<td>
				<select name="aid">
						<option value="0">Select Author</option>
						<%
							AuthorDao ad = new AuthorDao();
							List<AuthorBean> list = ad.authorList();
							
							for(int i=0;i<list.size();i++){
								AuthorBean ab = list.get(i);
						%>
								<option value="<%=ab.getaId()%>"><%=ab.getaName() %></option>
						
						<%} %>
				</select>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="SUBMIT"></td>
		</tr>
	
	
	</table>

</form>

</body>
</html>