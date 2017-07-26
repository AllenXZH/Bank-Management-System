<%@page import="java.util.ArrayList"%>
<%@page import="com.springmvc.entities.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Customers Profiles</h2>
	<h3>${sessionScope.loginedEmployee}</h3>
	<table>
	<tr>
		<th>customerId</th>
		<th>customerName</th>
		<th>gender</th>
	</tr>
	<c:forEach items="${requestScope.customerList}" var="customer">
	<tr>
		<td>${customer.id}</td>
		<td>${customer.customerName}</td>
		<td>${customer.gender}</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>