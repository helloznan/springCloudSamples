package com.waylau.spring.cloud.weather.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.UriEncoder;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.utils.StringUtils;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	@Autowired
	private RestTemplate restTemplate;
	private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";

	@Override
	public JSONObject getDataByCityId(String cityId) {
		String uri = WEATHER_API+"?cityKey="+cityId;
		return getByURI(uri);
	}

	@Override
	public JSONObject getDataByCityName(String cityName) {
		String uri = WEATHER_API+"?city="+cityName;
		return getByURI(uri);
		
	}
	
	private com.alibaba.fastjson.JSONObject getByURI(String uri) {

		try {
			File file = new File("/Users/zhengnan/Desktop/springCloudDemol/micro-weather-basic/src/main/resources/weather_mini.json");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			String str = "";
			while((line = br.readLine())!=null) {
				str+=line;
			}
			
//			System.out.println(str);
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(str);
//			System.out.println(obj.getJSONObject("date"));
			
			
			return obj;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return  null;
	
//		
//		String strBody= "";
//		
//		ObjectMapper mapper = new ObjectMapper();
//		WeatherResponse weather = null;
//		try {
//			weather = mapper.readValue(strBody, WeatherResponse.class);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		return weather;
	}

}
