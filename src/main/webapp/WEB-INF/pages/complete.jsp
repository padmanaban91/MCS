<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>${value}</h1>
	<form action="complete" method="post">
		<table>
			<tr>
				<td>Enter your name to complete workflow:</td>
				<td><input ng-model="a" name="username" type="text" /></td>
			</tr>
		</table>
		<input type="submit" value="Click Me!!">
	</form>
</body>
</html>