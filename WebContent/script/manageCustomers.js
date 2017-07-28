/**
 * 
 */

$(window).ready(function() { 
  $.getJSON("/Insurance-System/business/m/customers/1", function(result) {
	  printTable(result);
  }); 
});

$(document).ready(function(){
		$("button.page").on({
			click: function(){
				var page = $(this).text();
				$("#tbody").html("");
				$.getJSON('/Insurance-System/business/m/customers/' + page, function(result){
					printTable(result);
				});
			}
		});
		$("#searchButton").on({
			click: function() {
				var id = $("#searchId").val();
				var name = $("#searchName").val();
				var email = $("#searchEmail").val();
				if (id.length == 0 && name.length == 0 && email.length == 0) {
					$("#tbody").html("");
				} else {
					$("#tbody").html("");
					var url = '/Insurance-System/business/m/customers/s?';
					url += 'id=' + id;
					url += '&name=' + name;
					url += '&email=' + email;
					$.getJSON(url, function(result){
						printTable(result);
					});
				}				
			}	
		});	
		$(document).keydown(function(event){
		    if (event.which == 13) {
		    	$("#searchButton").trigger('click');
		    }
		});
});



function printTable(result) {
	for (var i = 0; i < result.length; i++) {
		$("#tbody").append(
				'<tr>' + 
			 	'<td class="tdId">' + result[i].id + '</td>' +
			 	'<td class="tdName">' + result[i].customerName + '</td>' +
			 	'<td class="tdEmail">' + result[i].email + '</td>' +
			 	'<td>' + result[i].gender + '</td>' +
			 	'<td>' + result[i].loan + '</td>' +
			 	'<td class="tdPassword" hidden>' + result[i].password + '</td>' +
			 	'</tr>'
		);
	}
	actShowPassword();
	renderTableRows();
}

function actShowPassword() {
	$("td.tdName").on({
		click: function() {
			var password = $(this).nextAll("td.tdPassword").text();
			var r = confirm('Password: ' + password);
		}
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