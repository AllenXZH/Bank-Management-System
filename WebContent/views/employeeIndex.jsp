<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DXF Insurance Management System | Home</title>
<link rel="stylesheet" href="/Insurance-System/css/general.css"/>
</head>

<body>
	<div class="narrow">
		<a href="/Insurance-System/" style="font-size:20px">HOME</a> 
		
		<h2>Employee Home</h2>
		<p>ID: ${sessionScope.loginedEmployeeId}  |  Official Name: ${sessionScope.loginedEmployeeName}
			 <button><a href="/Insurance-System/business/m/Logout" >Logout</a></button></p>
	</div>
	<hr>
	<div class="narrow">
		<p><a href="/Insurance-System/business/m/customers">Manage Customers</a></p>
		
		<p><a href="/Insurance-System/business/m/loans">Manage Loans</a></p>
		
		<p><a href="/Insurance-System/business/m/policies">Manage Policies</a></p>
	
	</div>
	
</body>
</html>