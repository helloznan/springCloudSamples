package com.waylau.spring.cloud.weather.service;

import com.alibaba.fastjson.JSONObject;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气数据服务
 * @author zhengnan
 *
 */
public interface WeatherDataService {
	/**
	 * 根据城市ID来查询数据
	 * @param cityId
	 * @return
	 *
	 * @author zhengnan
	 */
	JSONObject getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询数据
	 * @param cityName
	 * @return
	 *
	 * @author zhengnan
	 */
	JSONObject getDataByCityName(String cityName);
}
