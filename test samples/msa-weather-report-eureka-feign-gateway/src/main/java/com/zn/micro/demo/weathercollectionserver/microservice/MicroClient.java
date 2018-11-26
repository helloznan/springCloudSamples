package com.zn.micro.demo.weathercollectionserver.microservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zn.micro.demo.weathercollectionserver.vo.City;

@FeignClient(name="micro-weather-eureka-client-zuul")
public interface MicroClient {
	/**
	 * 访问城市数据服务
	 * @return
	 *
	 * @author zhengnan
	 */
	@RequestMapping("/cityGateway/cities/listCity")
	List<City> listCity();
	/**
	 * 访问天气数据服务
	 * @param cityId
	 * @return
	 *
	 * @author zhengnan
	 */
	@RequestMapping("/dataGateway/data/cityId/{cityId}")
	public JSONObject getByCityId(@PathVariable("cityId") String cityId);
	
	@RequestMapping("/dataGateway/data/cityName/{cityName}")
	public JSONObject getByCityName(@PathVariable("cityName") String cityName) ;
}
