/**
 * 
 */
package com.zn.micro.demo.weathercollectionserver.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
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
		if(stringRedisTemplate.hasKey(url)) {
			System.out.println("redis中有数据...");
			data = stringRedisTemplate.opsForValue().get(url);
			return JSONObject.parseObject(data);
		}else {
			System.out.println("redis中没有数据");
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			
			String str = "{}";
			if(response.getStatusCodeValue()==200) {
				str = response.getBody();
			}
			
			System.out.println(str);
			stringRedisTemplate.opsForValue().set(url, str);
			
			return JSONObject.parseObject(str);
		}
		
		
	}

}
