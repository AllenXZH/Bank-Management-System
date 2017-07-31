/**
 * 
 */
/**
 * 
 */

$(window).ready(function() { 
  $.getJSON("/Insurance-System/business/m/loans/1", function(result) {
	  printTable(result);
  }); 
});

$(document).ready(function(){
		$("button.page").on({
			click: function(){
				var page = $(this).text();
				$("#tbody").html("");
				$.getJSON('/Insurance-System/business/m/loans/' + page, function(result){
					printTable(result);
				});
			}
		});
		
});



function printTable(result) {	
	for (var i = 0; i < result.length; i++) {
		var date = getDateTime(new Date(result[i].loanDate));
		
		var approved;
		if (result[i].approved == 'Y') {
			approved = 'Approved';
		} else if (result[i].approved == 'N') {
			approved = 'Rejected';
		} else {
			approved = 'Undefined';
		}
		$("#tbody").append(
				'<tr>' + 
			 	'<td class="loanNo">' + result[i].loanNo + '</td>' +
			 	'<td style="font-size:12px">' + date + '</td>' +
			 	'<td>' + result[i].timePeriod + '</td>' +
			 	'<td>' + result[i].rateOfInterest + '</td>' +
			 	'<td class="tdApprove">' + approved + '</td>' +
			 	'<td class="tdButtons">' + 
			 	'<button class="tdButton" ><img class="tdBimg" alt="Y" src="/Insurance-System/images/approve-icon.png"></button>' + 
			 	'<button class="tdButton" ><img class="tdBimg" alt="N" src="/Insurance-System/images/reject-icon.png"></button>' + 
			 	'<button class="tdButton" ><img class="tdBimg" alt="D" src="/Insurance-System/images/delete-icon.png"></button>' + 
			 	'</td>' +
			 	'</tr>'
		);
	}
	$(".tdButtons").css("padding", "18px 5px 18px");
	actApprove();
	renderTableRows();
}

function actApprove() {
	$("td.tdApprove").each(function() {
		if ($(this).text() == 'Approved') {
			$(this).css('color', 'green');
			$(this).nextAll('td.tdButtons').html('');
		}
		if ($(this).text() == 'Rejected') {
			$(this).css('color', 'red');
			$(this).nextAll('td.tdButtons').html('');
		} 
	});
	$("button.tdButton").on({
		click: function() {
			var val = $(this).children(".tdBimg").attr("alt");
			if (val == 'Y') {
				var conf = confirm('Approve this loan?');
				if (conf == true) {
					approveRequest($(this).parent().prevAll('td.loanNo').text(), 'Y');
					$(this).parent().prevAll('.tdApprove').css("color", "green");
					$(this).parent().prevAll('.tdApprove').text('Approved');
					$(this).parent().attr("hidden", true);
				}
			}
			if (val == 'N') {
				var conf = confirm('Reject this loan?');
				if (conf == true) {
					approveRequest($(this).parent().prevAll('td.loanNo').text(), 'N');
					$(this).parent().prevAll('.tdApprove').css("color", "red");
					$(this).parent().prevAll('.tdApprove').text('Rejected');
					$(this).parent().attr("hidden", true);
				}
			}
			if (val == 'D') {
				var conf = confirm('Delete this loan?');
				if (conf == true) {
					deleteRequest($(this).parent().prevAll('td.loanNo').text());
					$(this).parent().prevAll('.tdApprove').css("color", "purple");
					$(this).parent().prevAll('.tdApprove').text('Deleted');
					$(this).parent().attr("hidden", true);
				}
			}
		}
	});
}
function approveRequest(id, approve) {
	$.ajax({
		url: '/Insurance-System/business/m/loan/' + id +'?approve=' + approve,
		type: 'PUT',
		success: function(response) {alert(response)}
	});
}

function deleteRequest(id) {
	$.ajax({
		url: '/Insurance-System/business/m/loan/' + id,
		type: 'DELETE',
		success: function(response) {alert(response)}
	});
}

function renderTableRows() {
	/* For zebra striping */
    $("table tr:nth-child(odd)").addClass("odd-row");
	/* For cell text alignment */
	$("table td:first-child, table th:first-child").addClass("first");
	/* For removing the last border */
	$("table td:last-child, table th:last-child").addClass("last");
}

function getDateTime(date) {
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hh = date.getHours();
    var mm = date.getMinutes();
    var ss = date.getSeconds();
    return year + "-" + month + "-" + day + "  " + hh + ":" + mm + ":" + ss;
}