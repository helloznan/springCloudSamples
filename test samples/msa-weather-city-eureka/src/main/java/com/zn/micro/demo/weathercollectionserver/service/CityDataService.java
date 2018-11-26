package com.zn.micro.demo.weathercollectionserver.service;

import java.util.List;

import com.zn.micro.demo.weathercollectionserver.vo.City;

/**
 * 获取城市列表
 * @author zhengnan
 *
 */
public interface CityDataService {
	public List<City> listCity() throws Exception;
}
