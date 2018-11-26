/**
 * 
 */
package com.zn.micro.demo.weathercollectionserver.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhengnan
 *
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	private String API="http://wthrcdn.etouch.cn/weather_mini";

	@Override
	public JSONObject getByCityId(String cityId) {
		String url = API+"?cityKey="+cityId;
		return getData(url);
	}

	@Override
	public JSONObject getByCityName(String cityName) {
		String url=API+"?city="+cityName;
		return getData(url);
	}
	
	private JSONObject getData(String url) {
		String data = null;
		
		return new JSONObject();
	}

}
