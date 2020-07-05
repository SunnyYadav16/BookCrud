<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${error }

<form action="AdminLoginController">

	<table>

		<tr>
			<td>Admin Email:</td>
			<td><input type="text" name="txtAdminEmail"></td>
		</tr>
		
		<tr>
			<td>Admin Password:</td>
			<td><input type="password" name="txtAdminPassword"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>

	</table>
</form>
</body>
</html>