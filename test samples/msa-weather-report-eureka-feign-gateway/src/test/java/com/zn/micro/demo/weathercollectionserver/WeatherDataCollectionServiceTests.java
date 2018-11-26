package com.zn.micro.demo.weathercollectionserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.micro.demo.weathercollectionserver.service.WeatherDataCollectionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataCollectionServiceTests {
	@Autowired
	private WeatherDataCollectionService service;

	@Test
	public void contextLoads() {
		service.getByCityName("福州市");
		
	}

}
