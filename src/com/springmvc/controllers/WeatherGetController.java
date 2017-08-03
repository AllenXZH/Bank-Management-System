package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.springmvc.entities.POJO.Weather;
import com.springmvc.entities.POJO.WeatherInfo;

@Controller
@RequestMapping("/weather")
public class WeatherGetController {
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping()
	@ResponseBody
	public Weather getWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {
		String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon;
		//http://api.openweathermap.org/data/2.5/weather?lat=40&lon=-75&appid=appid=ec2fbee005070c3c319c28d25afdcf3b
		url += "&appid=ec2fbee005070c3c319c28d25afdcf3b";
		//System.out.println("getting weather");
		WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
		return weatherInfo.getWeather()[0];
	}
}
