package com.zn.micro.demo.weathercollectionserver.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.zn.micro.demo.weathercollectionserver.utils.XmlBuilder;
import com.zn.micro.demo.weathercollectionserver.vo.City;
import com.zn.micro.demo.weathercollectionserver.vo.CityList;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		Resource resource = new ClassPathResource("citylist.xml");
		InputStream is= resource.getInputStream();
		
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer sb = new StringBuffer();
		String line=null;
		while((line = br.readLine())!=null) {
			sb.append(line);
		}
		
		br.close();
		
		CityList list =  (CityList)XmlBuilder.xmlStrToObject(CityList.class, sb.toString());
		
		
		return list.getCityList();
	}

}
