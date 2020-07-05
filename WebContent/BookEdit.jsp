<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="BookUpdateController">

	<input type="hidden" name="bid" value="${bookbean.bId }">
	<table>
		<tr>
			<td>Book Name:-</td>
			<td><input type="text" name="txtBookName" value="${bookbean.bName }"></td>
		</tr>
			
		<tr>
			<td>Book Price:-</td>
			<td><input type="text" name="txtBookPrice" value="${bookbean.bPrice }"></td>
		</tr>
	
		<tr>
			<td>Book Quantity:-</td>
			<td><input type="text" name="txtBookQuantity" value="${bookbean.bQty }"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="SUBMIT"></td>
		</tr>
	
	
	</table>

</form>

</body>
</html>