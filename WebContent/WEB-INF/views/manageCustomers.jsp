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
<script type="text/javascript" src="/Insurance-System/script/simpleTable.js"></script>
<style>
	button {
		margin-left: 5px;
		margin-right: 5px;
	}
</style>
</head>

<body>
<br>
<div class="narrow">
	<h2>Manage Customers</h2>
	<p>Total Customer: ${requestScope.customerNum}</p>

</div>
<hr>
<div class="narrow" >
	<table id="customerTable" cellspacing="0">
		<tr>
			<th width="200px">Customer ID</th>
			<th width="200px">Name</th>
			<th width="200px">Password</th>
			<th width="200px">Gender</th>
			<th width="200px">loan</th>
		</tr>
		<tbody id="tbody">
						
		</tbody>
	</table>
</div>
<div id="pageSelector" class="narrow" style="margin-top:20px;margin-bottom:50px">
		<p >
			<button id="lastpage">LastPage</button>
			<%
				int pageNum = (Integer)request.getAttribute("customerNum");
				if (pageNum % 10 != 0) {
					pageNum = (pageNum / 10) + 1;
				} else {
					pageNum = pageNum / 10;
				}
				for (int i = 0; i < pageNum; i++) {
					out.println("<button class='page'>"+ (i + 1) +"</button>");
				}
			%>
			<button id="nextPage">NextPage</button>
		</p>
</div>
<hr>
<div class="narrow" style="height:50px">

</div>
</body>
</html>