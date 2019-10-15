<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<Form action="Login" method="post">
		<div align="center" style="bgcolor:red">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" required="required"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"
					style="color: red; font-size: 20;"></td>
				</tr>
			</table>
		</div>
	</Form>
</body>
</html>