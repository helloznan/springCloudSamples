package com.waylau.spring.cloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest配置类
 * @author zhengnan
 *
 */
@Configuration
public class RestConfiguation {
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}
}
