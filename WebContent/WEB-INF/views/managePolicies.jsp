<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DXF Insurance Management System</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/Insurance-System/css/general.css"/>
<style type="text/css">
	input {
		font-size:18px;
		width:200px;
		margin:5px 0px 10px
	}
	input.type {
		font-size:18px;
		width:20px;
		margin:5px 0px 10px
	}
	#checkCustomer {
		font-size:18px;
		width:50px;
		margin:5px 0px 10px
	}
</style>
<script>
	$(window).ready(function(){
		setInterval(function(){
			$("#currentTime").text(new Date());
		}, 1000);		
	});
	$(document).ready(function(){
		$(document).keydown(function(event){
		    if (event.which == 13) {
		    	$("#submit").trigger('click');
		    }
		});	
		$("input").attr('required', 'required');
	});
	function checkValid() {
		var customerId = $("#CustomerId").val();
		var validation;
		if (customerId != '') {
			$.getJSON('/Insurance-System/business/m/customer/validation?customerId=' + customerId, function(result){
				if (result != null && result.length != 0) {
					$("#isValid").attr("hidden", true);
					$("#validName").text('Customer Name: ' + result[0].customerName);
				}			
			});
		}		
		$("#isValid").attr("hidden", false);
		$("#validName").text('');
		return true;
	}
	function submit() {
		//checkValid();
		$("#submit_h").trigger('click');
	}
</script>
</head>
<body>
	<div class="narrow">
		<a href="/Insurance-System/business/m/index" >
		<img alt="RETURN" src="/Insurance-System/images/home.jpeg" width="35px" height="35px"></a>
		<h2 style="margin-top:10px;margin-bottom:10px">New Policy</h2>
	</div>
	<hr>
	<div class="narrow" style="padding-left:200px">
		<form action="/Insurance-System/business/m/policy" method="post" target="resultFrame">
			CustomerID: <br>
			<input id="CustomerId" type="text" name="cusId" maxlength="9" /> 
			<input id="checkCustomer" type="button" onclick="checkValid()" value="check"/>
			<span id="isValid" style="color:red" hidden>Invalid CustomerID!</span>
			<span id="validName" style="color:green"></span><br>
			Policy Type:<br>
			<input class="type" name="type" type="radio" value="loan"/> Loan 
			<input class="type" name="type" type="radio" value="health"/> Health Insurance 
			<input class="type" name="type" type="radio" value="house"/> House Insurance
			<input class="type" name="type" type="radio" value="vehicle"/> Vehicle Insurance
			<br>
			Purchase Date:<br>
			<span id="currentTime" style="color:gray"></span><br>
			policy Start Date:<br>
			<input type="date" name="startDate"/><br>
			Policy Expired Date:<br>
			<input type="date" name="expDate"/><br>
			<input id="submit_h" hidden style="font-size:20px" type="submit" value="Submit"/>
		</form>
			<input id="submit" onclick="submit()" style="font-size:20px" type="button" value="Submit"/>
			<br><br><iframe name="resultFrame"></iframe>
	</div>
	<hr>
	<div class="narrow" style="height:200px">
	</div>
</body>
</html>