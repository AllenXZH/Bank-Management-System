<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DXF Insurance Management System</title>

<style type="text/css">
hr {
	display: block;
	margin-top: 1em;
	margin-bottom: 1em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
}
</style>

</head>
<body>
	<h1>Customer Login</h1>
	<hr>
	<form action="business/login" method="post">
		Username: <input name="username" /> 
		Password: <input name="password" />

		<input type="submit" value="LOGIN" />
	</form>


</body>
</html>