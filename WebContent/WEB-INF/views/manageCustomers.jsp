<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/Insurance-System/css/general.css"/>
<link rel="stylesheet" href="/Insurance-System/css/simpleTable.css"/>
<script type="text/javascript" src="/Insurance-System/script/manageCustomers.js"></script>
</head>

<body>
<br>
<div class="narrow">
	<h2>Manage Customers</h2>
	<p>Total Customer:  ${requestScope.customerNum}</p>

</div>
<hr>
<div class="narrow" >
	<table id="customerTable" cellspacing="0">
		<tr>
			<th width="200px" style="text-align:center">Customer ID</th>
			<th width="200px">Name</th>
			<th width="200px">Password</th>
			<th width="200px">Gender</th>
			<th width="200px">loan</th>
		</tr>
	</table>
</div>
</body>
</html>