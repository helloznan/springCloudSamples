/**
 * 
 */
package com.zn.micro.demo.weathercollectionserver.microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhengnan
 *
 */
@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {
	@RequestMapping("/data/cityId/{cityId}")
	public JSONObject getByCityId(@PathVariable("cityId") String cityId);
	
	@RequestMapping("/cityName/{cityName}")
	public JSONObject getByCityName(@PathVariable("cityName") String cityName) ;
}
