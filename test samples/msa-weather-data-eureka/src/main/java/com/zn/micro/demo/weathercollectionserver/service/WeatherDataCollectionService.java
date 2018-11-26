/**
 * 
 */
package com.zn.micro.demo.weathercollectionserver.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 数据采集service
 * @author zhengnan
 *
 */
public interface WeatherDataCollectionService {
	public JSONObject getByCityId(String cityId);
	public JSONObject getByCityName(String cityName);
}
