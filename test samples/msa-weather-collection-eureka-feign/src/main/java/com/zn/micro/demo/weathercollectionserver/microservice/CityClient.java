package com.zn.micro.demo.weathercollectionserver.microservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zn.micro.demo.weathercollectionserver.vo.City;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities/listCity")
	List<City> listCity();
}
