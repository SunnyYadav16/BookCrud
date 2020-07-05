<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${error }

<form action="UserLoginController">

	<table>

		<tr>
			<td>User Email:</td>
			<td><input type="text" name="txtUserEmail"></td>
		</tr>
		
		<tr>
			<td>User Password:</td>
			<td><input type="password" name="txtUserPassword"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>

	</table>
</form>

</body>
</html>