<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginDiv").slideToggle("slow");
		$("#submit").click(function() {
			if($("#username").val() != "" && $("#password").val() != "") {				
				$("#login").submit();		
			} else {
				alert("Both Username and Password are mandatory");
			} 
		});
	});	
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>${failMessage}</h1>
	<div id="loginDiv" style="display:none;background:#98bf21;position:absolute;">
		<form id="login" method="post" action="login">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input id="username" name="username" /></td>
				<tr>
					<td>Password:</td>
					<td><input id="password" name="password" type="password" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>