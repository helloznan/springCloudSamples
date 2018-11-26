package com.zn.micro.demo.weathercollectionserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zn.micro.demo.weathercollectionserver.service.WeatherDataCollectionService;

@RestController
@RequestMapping("/data")
public class WeatherDataController {
	@Autowired
	WeatherDataCollectionService service;
	
	@RequestMapping("/cityId/{cityId}")
	public JSONObject getByCityId(@PathVariable("cityId") String cityId) {
		return service.getByCityId(cityId);
	}
	
	@RequestMapping("/cityName/{cityName}")
	public JSONObject getByCityName(@PathVariable("cityName") String cityName) {
		return service.getByCityName(cityName);
	}
}
