package com.zn.micro.demo.weathercollectionserver.utils;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
		Object xmlObject = null;
		Reader reader=null;
		
		JAXBContext context = JAXBContext.newInstance(clazz);
		
		//将xml转成对象的核心接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		
		if(null!=reader) {
			reader.close();
		}
		
		return xmlObject;
	}
}
