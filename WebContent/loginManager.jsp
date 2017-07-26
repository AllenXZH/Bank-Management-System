<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DXF Insurance Management System</title>
<link rel="stylesheet" href="/Insurance-System/css/general.css"/>

</head>
<body>
	<div class="narrow">
		<a href="/Insurance-System/" style="font-size:20px">HOME</a>
		<h2>Manager Login</h2>
	</div>
	<hr>
	<div class="narrow">
	<form action="business/index/manager" method="post">
		<input type="hidden" name="_method" value="GET"/>
		User ID: <br><input class="login" name="id" /> 
		<p></p>
		Password: <br><input class="login" name="password" />
		<br><br>
		<input type="submit" value="LOGIN" style="width:100px"/>
	</form>
	</div>


</body>
</html>