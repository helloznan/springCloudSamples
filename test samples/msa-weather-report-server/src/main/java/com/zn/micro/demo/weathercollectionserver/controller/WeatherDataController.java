package com.zn.micro.demo.weathercollectionserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zn.micro.demo.weathercollectionserver.service.WeatherDataCollectionService;
import com.zn.micro.demo.weathercollectionserver.vo.City;

@Controller
@RequestMapping("/report")
public class WeatherDataController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataController.class);  
	@Autowired
	WeatherDataCollectionService service;
	
	@GetMapping("/cityName/{cityName}")
	public ModelAndView getReportByCityId(@PathVariable("cityName") String cityName, Model model) throws Exception {
		// TODO 改为由城市数据API微服务来提供数据
		
		List<City> cityList = null;
		try {
			// TODO 调用城市数据API
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityId("101280601");
			city.setCityName("深圳");
			cityList.add(city);
			
			city = new City();
			city.setCityId("101280301");
			city.setCityName("惠州");
			cityList.add(city);
			
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常!",e);
		}
		
		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityId", cityName);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", service.getByCityName(cityName));
		return new ModelAndView("/weather/report.html", "reportModel", model);
	}
}
