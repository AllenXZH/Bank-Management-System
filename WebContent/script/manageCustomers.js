/**
 * 
 */

$(window).ready(function() {
  
  $.getJSON("/Insurance-System/business/m/customers/page?page=1", function(result) {
     var records = result;
     
     for (var i = 0; i < records.length; i++) {
    	 $("#customerTable").append(
    			 '<tr>' + 
    			 	'<td>' + records[i].id + '</td>' +
    			 	'<td>' + records[i].customerName + '</td>' +
    			 	'<td>' + records[i].password + '</td>' +
    			 	'<td>' + records[i].gender + '</td>' +
    			 	'<td>' + records[i].loan + '</td>' +
    			 '</tr>'
    	 );
     }
    
     //printTable(10);
  });
  renderTableRows();
  
});

function renderTableRows() {
	/* For zebra striping */
    $("table tr:nth-child(odd)").addClass("odd-row");
	/* For cell text alignment */
	$("table td:first-child, table th:first-child").addClass("first");
	/* For removing the last border */
	$("table td:last-child, table th:last-child").addClass("last");
}