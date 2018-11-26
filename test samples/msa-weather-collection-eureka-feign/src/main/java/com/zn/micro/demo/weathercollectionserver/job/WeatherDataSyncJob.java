package com.zn.micro.demo.weathercollectionserver.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zn.micro.demo.weathercollectionserver.microservice.CityClient;
import com.zn.micro.demo.weathercollectionserver.service.WeatherDataCollectionService;
import com.zn.micro.demo.weathercollectionserver.vo.City;

public class WeatherDataSyncJob extends QuartzJobBean {
	@Autowired
	private CityClient cityClient;
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService ;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("开始执行调度...~~~");
		
		List<City> listCity = cityClient.listCity();
		if(listCity!=null) {
			for (City city : listCity) {
				System.out.println("查询"+city.getCityName()+"的天气数据");
				
				weatherDataCollectionService.getByCityName(city.getCityName());
				weatherDataCollectionService.getByCityId(city.getCityId());
			}
		}
	}
}
