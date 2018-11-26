package com.zn.micro.demo.weathercollectionserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zn.micro.demo.weathercollectionserver.service.CityDataService;
import com.zn.micro.demo.weathercollectionserver.vo.City;

@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityDataService cityDataService;
	
	@GetMapping
	public List<City> listCity() throws Exception{
		return this.cityDataService.listCity();
	}
}
