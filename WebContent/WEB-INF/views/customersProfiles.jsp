<%@page import="com.sprinmvc.entities.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customers Profiles</h1>
	
	<%
		List<Customer> list = (List<Customer>)request.getAttribute("customersProfiles");
		for (Customer customer : list) {
			out.println(customer);
		}
	%>
	
</body>
</html>