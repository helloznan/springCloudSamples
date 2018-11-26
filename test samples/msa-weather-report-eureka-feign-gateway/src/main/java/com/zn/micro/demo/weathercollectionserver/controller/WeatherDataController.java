package com.zn.micro.demo.weathercollectionserver.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zn.micro.demo.weathercollectionserver.microservice.MicroClient;
import com.zn.micro.demo.weathercollectionserver.service.WeatherDataCollectionService;
import com.zn.micro.demo.weathercollectionserver.vo.City;

@Controller
@RequestMapping("/report")
public class WeatherDataController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataController.class);  
	@Autowired
	WeatherDataCollectionService service;
	@Autowired
	MicroClient microClient;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		List<City> cityList = null;
		try {
			//查询城市列表
			cityList = microClient.listCity();
			
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常!",e);
		}
		
		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		//查询该城市天气信息
		model.addAttribute("report", microClient.getByCityId(cityId));
		return new ModelAndView("weather/report.html", "reportModel", model);
	}
}
