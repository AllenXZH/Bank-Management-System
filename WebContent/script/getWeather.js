/**
 * 
 */
$(window).ready(function() {
	if (navigator.geolocation) 
    { 
        navigator.geolocation.getCurrentPosition(showPosition); 
    } 
    else 
    { 
        $("#weather_desc").text("This browser does not support Geolocation"); 
    } 			
});

function showPosition(position) {
	var urlParam = "lat=" + position.coords.latitude + "&lon=" + position.coords.longitude;
    $.getJSON("business/weather?" + urlParam, function(weather) {
    	$("#weather_img").attr("hidden", false);
    	switch (weather.main) {
		case "Clear":
			$("#weather_img").attr("src", "images/weather/clear.png");
			break;
		case "Rain":
			$("#weather_img").attr("src", "");
			break;
		case "Snow":
			$("#weather_img").attr("src", "");
			break;
		case "Thunderstorm":
			$("#weather_img").attr("src", "images/weather/StormWithRain.png");
			break;
		default:
			$("#weather_img").attr("src", "images/weather/clear.png");
			break;
		}
    	
    	$("#weather_desc").text(weather.description);
    });
}
